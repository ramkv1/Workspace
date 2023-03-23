package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj07EmpSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07EmpSeviceApplication.class, args);
	}

}
