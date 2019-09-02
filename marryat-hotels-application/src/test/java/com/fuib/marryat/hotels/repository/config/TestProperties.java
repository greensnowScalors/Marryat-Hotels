package com.fuib.marryat.hotels.repository.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-test.properties")
@ConfigurationProperties(prefix = "test")
public class TestProperties {
}
