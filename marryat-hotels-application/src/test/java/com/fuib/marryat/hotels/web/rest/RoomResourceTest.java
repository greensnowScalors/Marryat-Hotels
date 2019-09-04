package com.fuib.marryat.hotels.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuib.marryat.hotels.repository.config.TestConfiguration;
import com.fuib.marryat.hotels.repository.config.TestProperties;
import com.fuib.marryat.hotels.repository.util.TestUtil;
import com.scalors.hotels.marryat.dto.reservations.RoomDTO;
import com.scalors.hotels.marryat.dto.user.UserDTO;
import com.scalors.hotels.marryat.exceptions.ExceptionHandlerController;
import com.scalors.hotels.marryat.resources.RoomResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@EnableConfigurationProperties(TestProperties.class)
@Sql(scripts = "/data.sql")
public class RoomResourceTest {

    @Autowired
    private TestProperties properties;

    @Autowired
    private ExceptionHandlerController exceptionHandler;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private RoomResource roomResource;
    private MockMvc restMockMvc;

    private UserDTO userDTO;

    private RoomDTO roomDTO;

    @Before
    public void init() {
        this.roomDTO = getReservationTemplate();
    }

    @Before
    public void setup() {
        restMockMvc = MockMvcBuilders.standaloneSetup(roomResource)
                .setControllerAdvice(exceptionHandler)
                .setConversionService(TestUtil.createFormattingConversionService())
                .build();
    }

    @Test
    public void contextLoads() {
        assertThat(properties).isNotNull();
    }

    @Test
    public void whenReservRoomThenCheckReservationReturnFalse() throws Exception {
        final MvcResult mvcResult = restMockMvc.perform(get("/rooms/{userId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.request().asyncStarted())
                .andReturn();

        restMockMvc
                .perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.room_id", is(1)));
    }

    @Test
    public void whenReservRoomWithAvailableDatesThenReturnOk() throws Exception {
        final MvcResult mvcResult = restMockMvc.perform(post("/rooms ")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(roomDTO)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.request().asyncStarted())
                .andReturn();

        restMockMvc
                .perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk());

    }

    @Test
    public void whenReservRoomWithNotAvailableDatesThenReturnBadRequest() throws Exception {
        final MvcResult mvcResult = restMockMvc.perform(post("/rooms ")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(roomDTO)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.request().asyncStarted())
                .andReturn();

        restMockMvc
                .perform(asyncDispatch(mvcResult))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void whenUpdateReservRoomOnOtherDatesThenOtherUserCanReservIt() throws Exception {
        //find by date range
        MvcResult reservationsByRange = restMockMvc.perform(get("/rooms/filter?from_date=2019-05-16&to_date=2019-09-18&hotel_id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        //get clientId
        String response = reservationsByRange.getResponse().getContentAsString();
        List<RoomDTO> rooms = Arrays.asList(objectMapper.readValue(response, RoomDTO[].class));
        RoomDTO bookedRoom = rooms.get(0);

        RoomDTO dto = getReservationTemplate();
        dto.setId(bookedRoom.getId());
        dto.setStartReserveDay(LocalDate.parse("2019-11-15"));
        dto.setEndReserveDay(LocalDate.parse("2019-11-18"));
        dto.setComment("124234");
        //update dto
        restMockMvc.perform(put("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        //book again on the same dates
        restMockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roomDTO)))
                .andExpect(status().is4xxClientError());
            }

    private RoomDTO getReservationTemplate() {
        return RoomDTO.builder()
                .roomId(1L)
                .userId(1L)
                .roomNumber(4L)
                .comment("with pet")
                .startReserveDay(LocalDate.parse("2019-09-15"))
                .endReserveDay(LocalDate.parse("2019-09-18"))
                .build();
    }
}
