package com.rk.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@Configurable
@ComponentScan(basePackages = "com.rk")
public class AppConfig {
	public AppConfig(){
		System.out.println("AppConfig::0-param Constructor");
	}
	
//	@Bean(name="ldt")
	@Bean
	@Scope("prototype")
	public LocalDateTime createLDT() {
		System.out.println("AppConfig.createLDT()");
		return LocalDateTime.now();
	}
}
