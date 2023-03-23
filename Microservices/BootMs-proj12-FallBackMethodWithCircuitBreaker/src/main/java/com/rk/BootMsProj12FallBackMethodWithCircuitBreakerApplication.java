package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BootMsProj12FallBackMethodWithCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj12FallBackMethodWithCircuitBreakerApplication.class, args);
	}

}
