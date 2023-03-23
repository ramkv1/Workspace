package com.rk.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception {

		/*
			//create InMemoryDb	as authenticationInfo provider
			auth.inMemoryAuthentication().withUser("Raja").password("{noop}Rani").roles("CLARK");
			auth.inMemoryAuthentication().withUser("Suresh").password("{noop}hyd").roles("MANAGER");
			auth.inMemoryAuthentication().withUser("Ramesh").password("{noop}delhi").roles("CLARK","MANAGER");
		*/
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Raja").password("$2a$10$NU2zKXC3FaVdOEBecx39LOMDpIvqFvRSq3vhC1RVyL7EO7TEKrzHi").roles("CLARK");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Suresh").password("$2a$10$LGT2S9IWkjjWkOB7ueIAvu6DF.ogNhG.t7qOomUXbVIpXwksE2G5m").roles("MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Ramesh").password("$2a$10$kwfs0gxn7.nhJTQ89LGNeehRluEi.2qXbXxsdeQZOOVNqH5WaZ3U.").roles("CLARK","MANAGER");
	
	}
	@Override
	public void configure(HttpSecurity http)throws Exception{
		//authorizeRequest
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyRole("CLARK","MANAGER")
		.antMatchers("/loan").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().rememberMe()		
		.and().logout()
		//.and().httpBasic()//Enable BASIC Authentication makes the browser generating the dialog box asking for username password
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
