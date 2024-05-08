package com.projeto.biblioteca_digital.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

public class WebSecurityConfig {
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/users/listar").hasAnyRole("USER", "MANAGER")
                        .requestMatchers("/users/criar").hasRole("MANAGER")
                        .requestMatchers("/users/id={id}").hasAnyRole("USER", "MANAGER")
                        .requestMatchers("/livros/listar").hasAnyRole("USER", "MANAGER")
                        .requestMatchers("/livros/criar").hasRole("MANAGER")
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails userManager = User.withDefaultPasswordEncoder()
                .username("manager")
                .password("manager123")
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user, userManager);
    }
     */
}
