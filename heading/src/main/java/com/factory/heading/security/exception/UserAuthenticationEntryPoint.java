package com.factory.heading.security.exception;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        // Kiểm tra nếu request yêu cầu tài nguyên cấm, trả về lỗi FORBIDDEN (403)
        if (request.getAttribute("isForbidden") != null && (Boolean) request.getAttribute("isForbidden")) {
            response.sendError(
                HttpServletResponse.SC_FORBIDDEN, 
                "Forbidden: You don't have permission to access this resource.");
        } else {
            // Nếu không, trả về lỗi UNAUTHORIZED (401)
            response.sendError(
                HttpServletResponse.SC_UNAUTHORIZED, 
                "Unauthorized: Authentication token was either missing or invalid.");
        }  
    }
    
}
