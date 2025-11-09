package com.leetjourney.spring_security_jwt.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allows requests from any origin to any endpoint
        registry.addMapping("/api/**")
                // IMPORTANT: In a development environment, use "*" to allow all origins.
                // For production, replace "*" with the specific URL where HTML page is hosted (e.g., "https://yourfrontend.com").
                .allowedOrigins("*") 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}

