//package com.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.entity.User;
//import com.repo.UserRepo;
//import com.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests(authorizeRequests -> 
//		authorizeRequests.requestMatchers("/", "/index").permitAll()
//		.requestMatchers("/css/**","/js/**","/images/**").permitAll()
//				.anyRequest().authenticated()).
//		formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
//				.logout(logout -> logout.permitAll());
//
//		return http.build();
//	}
////
////	@Autowired
////	public UserService uservice;
////	@Bean
////	public User SecurityConfig(String mail) {
////		return uservice.findUser(mail);
////	}
//	
//	
//	
//}
