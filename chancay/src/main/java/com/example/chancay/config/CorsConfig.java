package com.example.chancay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://10.0.2.2:8080, http://http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE") 
                .allowedHeaders("*");
    }
}