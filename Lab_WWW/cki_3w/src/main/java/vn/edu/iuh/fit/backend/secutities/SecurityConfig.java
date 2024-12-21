package vn.edu.iuh.fit.backend.secutities;


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
                        .requestMatchers("/dt/login").permitAll()
                        .requestMatchers("/dt/list").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/dt/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/dt").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/dt/update").permitAll()
                        .requestMatchers(HttpMethod.DELETE,"/api/dt/delete/**").permitAll()

                        // add phone thì cả user và admin đều được
                        .requestMatchers(HttpMethod.GET,"/dt/add").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/dt/add").hasAnyRole("USER","ADMIN")
                        // chỉ admin mới được sửa và xóa
                        .requestMatchers(HttpMethod.GET,"/dt/admin/edit/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/dt/admin/edit/{id}").hasRole("ADMIN")
                        .requestMatchers("/dt/admin/delete/{id}").hasRole("ADMIN")
                        // search thì cả user và admin đều được
                        .requestMatchers(HttpMethod.GET,"/dt/search").hasAnyRole("USER","ADMIN")
        ).formLogin(
                configure -> configure
                        .loginPage("/dt/login")
                        .loginProcessingUrl("/do-login")
                        .defaultSuccessUrl("/dt/list", true)
                        .failureUrl("/dt/login?error=true")
                        .permitAll()
        ).logout(
                configure -> configure
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/dt/login")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
