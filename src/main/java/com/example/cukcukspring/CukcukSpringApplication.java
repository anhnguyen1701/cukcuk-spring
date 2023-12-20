package com.example.cukcukspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CukcukSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CukcukSpringApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("http://localhost:8082");
//                registry.addMapping("/api/v1/employees").allowedOrigins("http://localhost:8082");
                registry.addMapping("/**") // Allow all paths
                        .allowedOrigins("*") // Allow requests from any origin
                        .allowedMethods("*") // Allow all HTTP methods (GET, POST, PUT, etc.)
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}
