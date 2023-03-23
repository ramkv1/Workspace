package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj08EmpSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08EmpSeviceApplication.class, args);
	}

}
