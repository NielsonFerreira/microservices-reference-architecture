package com.microservices.reference.gateway_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY_BASE64 = Base64.getEncoder().encodeToString(
            "minhaChaveSuperSeguraCom32Bytes!!!".getBytes()
    );

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1h
                .signWith(
                        Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY_BASE64)),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY_BASE64)))
                .parseClaimsJws(token)
                .getBody();
    }
}
