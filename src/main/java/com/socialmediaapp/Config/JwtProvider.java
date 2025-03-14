package com.socialmediaapp.Config;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtParser;

public class JwtProvider {

    private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes()); 
    private static final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    // Generate Token with 10 Days Expiry
    public static String generateToken(Authentication auth) {
        String token = Jwts.builder()
            .setIssuer("Gaurav")
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 864000000)) // 10 Days
            .claim("email", auth.getName())
            .signWith(key)
            .compact();
        
        System.out.println("Generated Token: " + token); // Debugging Purpose
        return token;
    }

    // Extract Email from Token
    public static String getEmailFromJwtToken(String jwt) {
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }

        Claims claims = jwtParser.parseClaimsJws(jwt).getBody();
        return claims.get("email", String.class);
    }

    // Token Validation Logic
    public static boolean validateToken(String token) {
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid or Expired Token: " + e.getMessage());
            return false;
        }
    }
}
