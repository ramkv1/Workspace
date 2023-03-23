package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj08ConfigServerNativeFileWithoutbootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08ConfigServerNativeFileWithoutbootstrapApplication.class, args);
	}

}
