package com.clogicsoftech.hroslite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS
                    )
            )

            .authorizeHttpRequests(auth -> auth

                    // Public APIs
                    .requestMatchers("/auth/**")
                    .permitAll()

                    // Swagger APIs
                    .requestMatchers(
                            "/v3/api-docs/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html"
                    )
                    .permitAll()

                    // Create employee
                    .requestMatchers(
                            HttpMethod.POST,
                            "/employee"
                    )
                    .hasAnyAuthority(
                            "SUPER_ADMIN",
                            "HR_ADMIN"
                    )

                    // Delete employee
                    .requestMatchers(
                            HttpMethod.DELETE,
                            "/employee/**"
                    )
                    .hasAuthority("SUPER_ADMIN")

                    // Update employee
                    .requestMatchers(
                            HttpMethod.PUT,
                            "/employee/**"
                    )
                    .hasAnyAuthority(
                            "SUPER_ADMIN",
                            "HR_ADMIN"
                    )

                    // View employees
                    .requestMatchers(
                            HttpMethod.GET,
                            "/employee/**"
                    )
                    .hasAnyAuthority(
                            "SUPER_ADMIN",
                            "HR_ADMIN",
                            "MANAGER",
                            "EMPLOYEE"
                    )

                    .anyRequest()
                    .authenticated()
            )

            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}