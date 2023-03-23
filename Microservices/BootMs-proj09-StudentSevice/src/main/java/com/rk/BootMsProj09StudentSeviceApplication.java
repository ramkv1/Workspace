package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj09StudentSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09StudentSeviceApplication.class, args);
	}

}
