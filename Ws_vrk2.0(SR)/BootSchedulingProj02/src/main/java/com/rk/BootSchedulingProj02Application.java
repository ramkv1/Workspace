package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj02Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj02Application.class, args);
	}

}
