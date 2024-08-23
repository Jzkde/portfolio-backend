package com.portfolio.back.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // Método que intenta autenticar al usuario basado en las credenciales proporcionadas.
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // Crea una instancia de AuthCredentials para almacenar las credenciales de autenticación.
        AuthCredentials authCredentials = new AuthCredentials();

        try {
            // Lee las credenciales del cuerpo de la solicitud y las convierte en un objeto AuthCredentials.
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crea un objeto UsernamePasswordAuthenticationToken con el email y la contraseña del usuario.
        UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                Collections.emptyList() // Roles vacíos en este ejemplo.
        );

        // Utiliza el AuthenticationManager para autenticar al usuario.
        return getAuthenticationManager().authenticate(usernamePat);
    }

    // Método que se llama cuando la autenticación es exitosa.
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // Obtiene los detalles del usuario autenticado.
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        // Crea un token JWT utilizando los detalles del usuario.
        String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());

        // Agrega el token JWT al encabezado de la respuesta.
        response.addHeader("Authorization", "Bearer " + token);

        // Limpia el flujo de salida de la respuesta.
        response.getWriter().flush();

        // Llama al método de autenticación exitosa de la clase base para manejar cualquier lógica adicional.
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
