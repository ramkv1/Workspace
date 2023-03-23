package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class BootSecurityproj03SecurityAppSpringDataJPAApplication {

	@Bean
	public BCryptPasswordEncoder createBCPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootSecurityproj03SecurityAppSpringDataJPAApplication.class, args);
	}

}
