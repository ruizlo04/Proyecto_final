package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	/*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
        		.username("admin")
        		.password("{noop}admin")
        		.roles("ADMIN")
        	.build();
        return new InMemoryUserDetailsManager(user);
    }*/
	
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	
	@Bean
	public AuthenticationManager 
			authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
		
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
<<<<<<< HEAD
	    .authorizeRequests()
	        .antMatchers("/css/**", "/js/**", "/h2-console/**").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	    .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/index", true)
	        .permitAll();

=======
		.authorizeHttpRequests()
			.requestMatchers("/css/**","/js/**", "/h2-console/**").permitAll()
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/index", true)
			.permitAll();
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
		
		// Añadimos esto para poder seguir accediendo a la consola de H2
		// con Spring Security habilitado.
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
	
	
	
}
