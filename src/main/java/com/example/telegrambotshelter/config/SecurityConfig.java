package com.example.telegrambotshelter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/swagger-ui/**", "/javainuse-openapi/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutSuccessUrl("/")
        ;
        return http.build();
    }
}
