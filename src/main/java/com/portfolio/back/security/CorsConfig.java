/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Jzkd
 */

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfirurer(){
        return new WebMvcConfigurer(){
                    @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login/")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .exposedHeaders("*");
                
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
