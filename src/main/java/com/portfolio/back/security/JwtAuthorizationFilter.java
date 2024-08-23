package com.portfolio.back.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    // Método que se ejecuta una vez por solicitud para procesar el filtro.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el token JWT del encabezado de autorización.
        String bearerToken = request.getHeader("Authorization");

        // Verifica si el encabezado de autorización contiene un token JWT válido.
        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            // Extrae el token JWT del encabezado.
            String token = bearerToken.replace("Bearer ", "");

            // Obtiene la autenticación del token utilizando TokenUtils.
            UsernamePasswordAuthenticationToken usernamePat = TokenUtils.getAuthentication(token);

            // Establece la autenticación en el contexto de seguridad de Spring.
            SecurityContextHolder.getContext().setAuthentication(usernamePat);
        }

        // Continúa con el siguiente filtro en la cadena.
        filterChain.doFilter(request, response);
    }
}
