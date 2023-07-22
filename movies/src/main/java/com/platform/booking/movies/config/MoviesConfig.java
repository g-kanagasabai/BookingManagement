package com.platform.booking.movies.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MoviesConfig {
    @Bean
    public WebClient createWebClient(){
        return WebClient.create();
    }
}
