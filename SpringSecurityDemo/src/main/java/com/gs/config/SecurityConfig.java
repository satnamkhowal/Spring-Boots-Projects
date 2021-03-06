package com.gs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
			
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests().antMatchers("/api/user/**").hasAnyRole("admin","user")
		.and().formLogin();
		http.csrf().disable().authorizeRequests().antMatchers("/api/admin/**").hasAnyRole("admin")
		.and().formLogin();
	}
	@Autowired
	public void cofigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jai").password("{noop}jai123").roles("admin","user");
		auth.inMemoryAuthentication().withUser("veeru").password("{noop}veeru123").roles("user");
	}
}
