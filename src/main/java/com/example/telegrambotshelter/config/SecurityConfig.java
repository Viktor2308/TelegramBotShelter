package com.example.telegrambotshelter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$liP5NFil0ljFIqva8Sly/ua1OWVW3KXc5201h2iHEDr61zgzm7zy2")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$liP5NFil0ljFIqva8Sly/ua1OWVW3KXc5201h2iHEDr61zgzm7zy2")
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
