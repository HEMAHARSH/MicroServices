package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;

	@SuppressWarnings("removal")
//	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeHttpRequests()
//		.requestMatchers("/auth/**")
//		.permitAll()
//		.anyRequest().authenticated().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().authenticationProvider(authenticationProvider)
//		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();

		http.csrf().disable().authorizeHttpRequests()
				.requestMatchers("/auth/**").permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
