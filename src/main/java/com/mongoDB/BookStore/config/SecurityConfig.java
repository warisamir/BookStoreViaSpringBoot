package com.mongoDB.BookStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetail1= User.withUsername("User1").password(passwordEncoder().encode("waris")).build();
        UserDetails userDetails2= User.withUsername("User2").password(passwordEncoder().encode("aman")).build();
        UserDetails userDetails3= User.withUsername("Admin").password(passwordEncoder().encode("aman")).build();
        return new InMemoryUserDetailsManager(userDetail1,userDetails2,userDetails3);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrfCustomizer->csrfCustomizer.disable());
        httpSecurity.authorizeHttpRequests(request-> request.requestMatchers("/bookStore/welcome").permitAll().anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }
}
