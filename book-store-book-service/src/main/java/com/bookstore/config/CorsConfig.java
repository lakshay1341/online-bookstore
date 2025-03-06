package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api-docs/**")
                        .allowedOrigins("https://lakshay1341.github.io")
                        .allowedMethods("GET")
                        .allowedHeaders("*");
                registry.addMapping("/swagger-ui/**")
                        .allowedOrigins("https://lakshay1341.github.io")
                        .allowedMethods("GET")
                        .allowedHeaders("*");
            }
        };
    }
}