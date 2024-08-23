package com.portfolio.back.security;

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

                // Configuración para el endpoint /login/
                registry.addMapping("/login/")
                        .allowedOriginPatterns("http://*", "https://*") // Permite subdominios de example.com.
                        .allowedMethods("POST") // Solo permite el método POST.
                        .allowedHeaders("*") // Permite todos los encabezados (puedes especificar según necesidad).
                        .exposedHeaders("Authorization") // Expone el encabezado Authorization.
                        .allowCredentials(true); // Permite el envío de credenciales.

                // Configuración para todos los endpoints bajo /api/**
                registry.addMapping("/api/**")
                        .allowedOriginPatterns("http://*", "https://*") // Permite subdominios de example.com.
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite los métodos necesarios.
                        .allowedHeaders("*") // Permite todos los encabezados (puedes especificar según necesidad).
                        .allowCredentials(true); // Permite el envío de credenciales (cookies, autenticación HTTP).
            }
        };
    }
}
