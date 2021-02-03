package com.vetApplication.program.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class JwtUtil {
    // Metodo para crear el JWT y enviarlo al cliente en el header de la respuesta.
    static void addAuthentication(HttpServletResponse res, String username){
        String token = Jwts.builder()
                .setSubject(username)

                // Hash con el que firmaremos la clave
                .signWith(SignatureAlgorithm.HS256,"P@tit0")
                .compact();

        // Agregamos el encabezado en el token
        res.addHeader("Authorization","bearer " + token);
    }

    // Metodo para validar el token enviado por el cliente
    static Authentication getAuthentication(HttpServletRequest request){
        // Obtenemos el token que viene en el encabezado de la peticion
        String token = request.getHeader("Authorization");

        // si hay un token presente, entonces lo validamos
        if(token != null){
            String user = Jwts.parser()
                    .setSigningKey("P@tit0")
                    .parseClaimsJws(token.replace("Bearer",""))
                    .getBody()
                    .getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList())
                                : null;
        }
        return null;
    }
}
