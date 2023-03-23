package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj07ConfigServerNativeFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07ConfigServerNativeFileApplication.class, args);
	}

}
