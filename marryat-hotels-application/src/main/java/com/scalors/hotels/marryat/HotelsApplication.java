package com.scalors.hotels.marryat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.scalors")
@EntityScan(basePackages = "com.scalors.marryat.hotels.entities")
public class HotelsApplication {
    public static void main(String[] args) {

        SpringApplication.run(HotelsApplication.class, args);
    }
}
