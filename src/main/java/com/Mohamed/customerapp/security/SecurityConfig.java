package com.Mohamed.customerapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   //@Order(1)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
                .csrf(Customizer.withDefaults())// utliser la configuration par defaut
                .authorizeHttpRequests(ar->ar.requestMatchers("/","/webjars/**","/h2-console/**").permitAll())
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout((logout)-> logout
                        //.logoutSuccessUrl("/").permitAll() // lorsque je fait un logout il me retourne vers le path "/"
                        .deleteCookies("JSESSIONID"))
                .build();
    }

   /* @Order(2)
    @Bean
    public SecurityFilterChain clientFilterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests(auth-> auth.requestMatchers(new AntPathRequestMatcher("/products/**")).hasRole("admin"));
       return http.build();
    }*/
}
