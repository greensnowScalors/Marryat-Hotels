package com.fuib.marryat.hotels.web.rest;

import com.fuib.marryat.hotels.repository.config.TestConfiguration;
import com.fuib.marryat.hotels.repository.config.TestProperties;
import com.fuib.marryat.hotels.repository.util.TestUtil;
import com.scalors.hotels.marryat.exceptions.ExceptionHandlerController;
import com.scalors.hotels.marryat.resources.UserResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@EnableConfigurationProperties(TestProperties.class)
@Sql(
        scripts = "/data.sql"
)
public class ClientsResourceTest {

    @Autowired
    private TestProperties properties;

//    @Autowired
    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private ExceptionHandlerController exceptionHandler;


    @Autowired
    private UserResource userResource;
    private MockMvc restMockMvc;

    private Map<String, String> headers;
    private static final String PATTERN = "yyyy-MM-dd";

    @Before
    public void setup() {
        restMockMvc = MockMvcBuilders.standaloneSetup(userResource)
                .setControllerAdvice(exceptionHandler)
                .setConversionService(TestUtil.createFormattingConversionService())
                .setMessageConverters(jacksonMessageConverter)
                .build();
    }


    @Test
    public void contextLoads() {
        assertThat(properties).isNotNull();
    }

    @Test
    public void whenAddUserThenCheckThem() throws Exception {

        restMockMvc.perform(get("/users/{userId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login", is("test1")));
//                .andExpect(jsonPath("$.document_list[0].amount",is(1234556.0)));
    }


}