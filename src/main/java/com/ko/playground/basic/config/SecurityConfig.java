package com.ko.playground.basic.config;

import com.ko.playground.basic.auth.ParentAuthenticationProvider;
import com.ko.playground.basic.auth.RoleBasedAuthenticationFilter;
import com.ko.playground.basic.auth.SantaAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final ParentAuthenticationProvider parentAuthenticationProvider;
    private final SantaAuthenticationProvider santaAuthenticationProvider;
    
    @Bean
    public AuthenticationManager customAuthenticationManager() {
        return new ProviderManager(Arrays.asList(
            parentAuthenticationProvider,
            santaAuthenticationProvider
        ));
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authManager = customAuthenticationManager();
        
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/parent/login", "/api/santa/login", "/api/logout").permitAll()
                .requestMatchers("/api/parent/**").hasRole("PARENT")
                .requestMatchers("/api/santa/**").hasRole("SANTA")
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
            )
            .addFilterBefore(new RoleBasedAuthenticationFilter("/api/parent/login", "PARENT", authManager), 
                           UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new RoleBasedAuthenticationFilter("/api/santa/login", "SANTA", authManager), 
                           UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}