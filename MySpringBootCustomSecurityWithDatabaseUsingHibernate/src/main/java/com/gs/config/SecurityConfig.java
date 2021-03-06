package com.gs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gs.service.impl.UserDetailsServiceImpl;
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
		@Autowired
		private UserDetailsServiceImpl userDetailsServiceImpl;
		
		@Autowired
		private TopicAuthenticationEntryPoint topicAuthenticationEntryPoint;
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
					http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
					.and().httpBasic().realmName("Topic security application Realm")
					.authenticationEntryPoint(topicAuthenticationEntryPoint);
		}
		@Autowired
		protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("hello");
			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
			auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
		}
}
