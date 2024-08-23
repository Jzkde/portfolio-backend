package com.portfolio.back.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private UserDetailsService userDetailsService;
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    // Configura la cadena de filtros de seguridad, incluyendo los detalles de autenticación y autorización.
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        // Filtro para gestionar la autenticación JWT.
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);

        // Establece la URL donde se procesará la autenticación.
        jwtAuthenticationFilter.setFilterProcessesUrl("/login/");

        return http

                // Habilita el soporte para CORS (Cross-Origin Resource Sharing).
                .cors()
                .and()

                // Deshabilita CSRF (Cross-Site Request Forgery) ya que se usa JWT que es inmune a CSRF.
                .csrf().disable()

                // Permite todas las solicitudes GET sin autenticación.
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET)
                        .permitAll()

                        // Requiere autenticación para cualquier otra solicitud.
                        .anyRequest()
                        .authenticated()
                        .and())

                // Define la política de creación de sesiones como "sin estado" (stateless) ya que se usa JWT.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Configura el AuthenticationManager que gestiona la autenticación de usuarios.
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)

                // Configura el servicio que se usará para obtener los detalles del usuario.
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
