package com.factory.heading.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

    @Value("${spring.jjwt.secret}")
    private String SECRET;

    @Value("${spring.jjwt.expiration}")
    private String EXPIRATION_TIME;

    private Key key;

    /**
     * init
     */
    @PostConstruct
    public void init() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    /**
     * READ
     */
    public Claims getAllClaimsFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return null;
    }

    public String getUsernameFromToken(String token) {
        try {
            return getAllClaimsFromToken(token).getSubject();
        } catch (Exception e) {
            log.error("Claims token invalid");
        }
        return null;
    }

    public Date getExpireDateFromToken(String token) {
        try {
            return getAllClaimsFromToken(token).getExpiration();
        } catch (Exception e) {
            log.error("Claims token invalid");
        }
        return null;
    }

    public Boolean isTokenValid(String token) {
        try {
            final Date expireDateToken = getExpireDateFromToken(token);
            return expireDateToken.before(new Date());
        } catch (Exception e) {
            log.error("Claims token invalid");
        }
        return null;
    }


    /**
     * WRITE
     */
    public String createToken(UserDetails userDetailsImpl) {
        Long expireTime = Long.parseLong(EXPIRATION_TIME);
        final Date createdDate = new Date();
        final Date expiredDate = new Date(createdDate.getTime() + expireTime);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("roles", userDetailsImpl.getAuthorities());
        return Jwts.builder()
                   .setSubject(userDetailsImpl.getUsername())
                   .setIssuedAt(createdDate)
                   .setExpiration(expiredDate)
                   .setClaims(claims)
                   .signWith(key)
                   .compact();
    }
}
