package com.fuib.marryat.hotels.web.rest;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@EnableConfigurationProperties(TestProperties.class)
@Sql(scripts = "/data.sql")
public class RoomTest {

    @Autowired
    private TestProperties properties;

    @Autowired
    private ExceptionHandlerController exceptionHandler;


    @Autowired
    private RoomResource roomResource;
    private MockMvc restMockMvc;

    private UserDTO userDTO;

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

    private RoomDTO getReservationTemplate() {
        return RoomDTO.builder()
                .roomId(1L)
                .userId(1L)
                .comment("with pet")
                .startReserveDay(LocalDate.now().plusDays(10))
                .endReserveDay(LocalDate.now().plusDays(15))
                .build();
    }
}
