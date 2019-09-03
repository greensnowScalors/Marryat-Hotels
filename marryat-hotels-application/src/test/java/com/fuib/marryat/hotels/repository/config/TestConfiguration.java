package com.fuib.marryat.hotels.repository.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.scalors.hotels.marryat.configutrations.SwaggerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
@ComponentScan(basePackages = {"com.scalors"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { SwaggerConfiguration.class}))
//@EnableConfigurationProperties({ApplicationProperties.class})
public class TestConfiguration {

//    @MockBean
//    public RetryTemplate retryTemplate;
//    @Autowired
//    private Jaxb2Marshaller jaxb2Marshaller;
//
//    @MockBean
//    private TracerWrapper tracerWrapper;
//
//    @MockBean
//    private WebServiceTemplate webServiceTemplate;
//    @MockBean
//    private WebServiceMessageSender webServiceMessageSender;
//
//    @Bean
//    public Jaxb2Marshaller jaxb2Marshaller() {
//        return jaxb2Marshaller;
//    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

//    @Bean
//    public ScroodgeDealingMessageSender scroodgeDealingMessageSender() {
//        ScroodgeDealingMessageSender sender = new ScroodgeDealingMessageSender();
//        sender.setWebServiceTemplate(webServiceTemplate);
//        return sender;
//    }
}
