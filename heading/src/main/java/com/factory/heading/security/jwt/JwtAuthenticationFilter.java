package com.factory.heading.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.factory.heading.security.detail.UserDetailServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;
    
    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            String username = jwtUtils.getUsernameFromToken(jwt);

            if (StringUtils.hasText(jwt) && jwtUtils.isTokenValid(jwt)) {
                UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(username);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, // principal
                        null,  // credentials
                        userDetails.getAuthorities() // authorities
                    );

                    // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
                    authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            log.error("failed on set user authentication", e);
        }

        filterChain.doFilter(request, response);
    }
    
    protected String getJwtFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (!token.isEmpty()) {
            if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
                return token.substring(7);
            }
        }
        return null;
    }
}
