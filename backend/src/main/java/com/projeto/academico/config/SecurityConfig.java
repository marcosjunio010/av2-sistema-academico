package com.projeto.academico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/actuator/health", "/h2-console/**").permitAll()
              .requestMatchers("/api/**").authenticated()
          )
          .csrf(csrf -> csrf.disable())
          .headers(headers -> headers.frameOptions().disable())
          .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }
}