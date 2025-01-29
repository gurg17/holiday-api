package com.george.holiday_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Define RestTemplate as a bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}