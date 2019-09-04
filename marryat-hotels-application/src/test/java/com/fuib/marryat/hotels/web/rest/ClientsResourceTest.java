package com.fuib.marryat.hotels.web.rest;

import com.fuib.marryat.hotels.repository.config.TestConfiguration;
import com.fuib.marryat.hotels.repository.config.TestProperties;
import com.fuib.marryat.hotels.repository.util.TestUtil;
import com.scalors.hotels.marryat.dto.user.UserDTO;
import com.scalors.hotels.marryat.exceptions.ExceptionHandlerController;
import com.scalors.hotels.marryat.resources.UserResource;
import com.scalors.marryat.hotels.entities.users.AccessType;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@EnableConfigurationProperties(TestProperties.class)
@Sql(scripts = "/data.sql")
public class ClientsResourceTest {

    @Autowired
    private TestProperties properties;

    @Autowired
    private ExceptionHandlerController exceptionHandler;


    @Autowired
    private UserResource userResource;
    private MockMvc restMockMvc;

    private UserDTO userDTO;

    @Before
    public void setup() {
        restMockMvc = MockMvcBuilders.standaloneSetup(userResource)
                .setControllerAdvice(exceptionHandler)
                .setConversionService(TestUtil.createFormattingConversionService())
                .build();
    }

    @Before
    public void init() {
        this.userDTO = UserDTO.builder()
                .accessType(AccessType.USER)
                .firstName("test")
                .lastName("test")
                .login("testUser")
                .build();
    }

    @Test
    public void contextLoads() {
        assertThat(properties).isNotNull();
    }

    @Test
    public void whenGetUserThenReturnItTest() throws Exception {

     restMockMvc.perform(get("/users/{userId}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login", is("test1")));

    }

    private UserDTO getUserDTORequest() {
        return UserDTO.builder()
                .accessType(AccessType.USER)
                .firstName("test")
                .lastName("test")
                .login("testUser")
                .build();

    }


}