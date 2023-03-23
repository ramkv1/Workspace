package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj16EurekaServerZuulAPIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj16EurekaServerZuulAPIGatewayApplication.class, args);
	}

}
