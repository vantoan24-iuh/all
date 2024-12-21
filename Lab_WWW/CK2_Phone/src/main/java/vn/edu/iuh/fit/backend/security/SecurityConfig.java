/**
 * @ (#) SecurityConfig.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user") // create a user
                .password(encoder.encode("123")) // encode the password
                .roles("USER") // assign role
                .build();
        UserDetails admin = User.withUsername("admin") // create a user
                .password(encoder.encode("123")) // encode the password
                .roles("ADMIN") // assign role
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        configure -> configure
                                .requestMatchers("/css/**", "js/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/index").hasAnyRole("USER","ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api/phones/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/phones").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/phones").permitAll()
                                .requestMatchers(HttpMethod.DELETE,"/api/phones/**").permitAll()

                                .requestMatchers(HttpMethod.GET,"/user/phones/add_new").hasRole("USER")
                                .requestMatchers(HttpMethod.GET,"/admin/phones/{id}/edit").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/phones/save").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/admin/phones/{id}/delete").hasRole("ADMIN")
        ).formLogin(
                configure -> configure
                        .loginPage("/login")
                        .loginProcessingUrl("/do-login")
                        .defaultSuccessUrl("/index", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
        ).logout(
                configure -> configure
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
