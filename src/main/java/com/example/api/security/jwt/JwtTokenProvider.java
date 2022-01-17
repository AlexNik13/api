package com.example.api.security.jwt;


import com.example.api.model.Role;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private String secretKey = "secretsecretsecretsecretsecret";
    private final long validityInMilliseconds = 3600000; // 1h

    private final JwtUserDetails jwtUserDetails;

    public JwtTokenProvider(JwtUserDetails jwtUserDetails) {
        this.jwtUserDetails = jwtUserDetails;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


    public String createToken(String email, Role role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("auth", role);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
//HS256
        return "Bearer " +  token;
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = jwtUserDetails.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserName(String token){
        String email = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        return email;
    }

    public boolean validateToken(String token) {
           Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
           if (claims.getBody().getExpiration().before(new Date())) {
               return false;
           }
           return true;
    }


    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
