package com.rk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.rk.service.IUserInfoService;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUserInfoService userService;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception {

		/*
			//create InMemoryDb	as authenticationInfo provider
			auth.inMemoryAuthentication().withUser("Raja").password("{noop}Rani").roles("CLERK");
			auth.inMemoryAuthentication().withUser("Suresh").password("{noop}hyd").roles("MANAGER");
			auth.inMemoryAuthentication().withUser("Ramesh").password("{noop}delhi").roles("CLERK","MANAGER");
		*/
		
		/*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Raja").password("$2a$10$NU2zKXC3FaVdOEBecx39LOMDpIvqFvRSq3vhC1RVyL7EO7TEKrzHi").roles("CLARK");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Suresh").password("$2a$10$LGT2S9IWkjjWkOB7ueIAvu6DF.ogNhG.t7qOomUXbVIpXwksE2G5m").roles("MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("Ramesh").password("$2a$10$kwfs0gxn7.nhJTQ89LGNeehRluEi.2qXbXxsdeQZOOVNqH5WaZ3U.").roles("CLARK","MANAGER");
		*/
		/*auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD FROM security_users WHERE UNAME=?")//For authentication
		.authoritiesByUsernameQuery("SELECT UNAME_ROLES FROM security_roles WHERE UNAME=?");//Foe Authorization
		*/
		//Use Spring DataJPA based Authentication info provider
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}
	@Override
	public void configure(HttpSecurity http)throws Exception{
		//authorizeRequest
		http.authorizeRequests().antMatchers("/bank").permitAll()
		.antMatchers("/user/register").authenticated()
		.antMatchers("/bank/offers").hasAnyAuthority("CLERK","MANAGER")
		.antMatchers("/bank/loan").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().rememberMe()		
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		//.and().httpBasic()//Enable BASIC Authentication makes the browser generating the dialog box asking for username password
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
