package com.factory.heading.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.factory.heading.security.detail.UserDetailServiceImpl;
import com.factory.heading.security.jwt.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Autowired
    protected UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    protected JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    protected PBKDF2PasswordEncoder pbkdf2PasswordEncoder;

    @Autowired
    protected AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.disable())
            .sessionManagement(session -> session.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(formLogin -> formLogin.disable())
            .csrf(csrf -> csrf.disable())
            .logout(logout -> logout.disable());
        
        http
            .exceptionHandling(exception -> 
                exception.authenticationEntryPoint(authenticationEntryPoint))
            .authorizeHttpRequests(author ->
                author.anyRequest()
                      .authenticated()
                      .requestMatchers("/login").permitAll()
                      .requestMatchers("/**").permitAll()
                      .anyRequest().authenticated());
        
        http.addFilterBefore(
            jwtAuthenticationFilter, 
            UsernamePasswordAuthenticationFilter.class
        );
        
        return http.build();

    }
}
