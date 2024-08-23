package com.portfolio.back.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    // Clave secreta utilizada para firmar el JWT. Debe ser mantenida en secreto y puede ser generada de forma más segura.
    private final static String ACCESS_TOKEN_SECRET = "575e4549213335397a2f7b3e2e40206525216a5832757724396545775379583f";

    // Tiempo de validez del token en segundos. Aquí se establece en 1800 segundos (30 minutos).
    private final static int ACCESS_TOKEN_VALIDITY_SECONDS = 1800;

    // Método para crear un token JWT.
    public static String createToken(String nombre, String email) {

        // Calcula el tiempo de expiración del token en milisegundos.
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        // Crea un mapa para incluir información adicional en el token.
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        // Construye el token JWT.
        return Jwts.builder().setSubject(email) // Establece el sujeto del token (en este caso, el email del usuario).
                .setExpiration(expirationDate) // Establece la fecha de expiración del token.
                .addClaims(extra) // Agrega las reclamaciones adicionales al token.
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())) // Firma el token con la clave secreta.
                .compact(); // Compone y retorna el token JWT.
    }

    // Método para obtener la autenticación a partir de un token JWT.
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {

            // Analiza el token JWT y obtiene las reclamaciones (claims) del token.
            Claims claims = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()) // Establece la clave secreta para verificar la firma del token.
                    .build().parseClaimsJws(token) // Analiza el token y obtiene las reclamaciones.
                    .getBody();

            // Obtiene el email del sujeto del token.
            String email = claims.getSubject();

            // Retorna un objeto de tipo UsernamePasswordAuthenticationToken con el email del usuario.
            // Se pasan roles vacíos ya que este ejemplo no gestiona roles en el token.
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            // Si hay algún error al analizar el token, retorna null indicando que la autenticación falló.
            return null;
        }
    }
}
