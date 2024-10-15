package com.example.EmployeeLiveProject.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/error", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/employees/**").authenticated()
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/login")  // Custom login page
                        .defaultSuccessUrl("/employees", true)  // Redirect after successful login
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }
}
