package com.rk.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
		@Override
	public void configure(HttpSecurity http)throws Exception{
		
		http.authorizeRequests().antMatchers("/","/login","/home").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()
		;
		}
}
