package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj09EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09EurekaServerApplication.class, args);
	}

}
