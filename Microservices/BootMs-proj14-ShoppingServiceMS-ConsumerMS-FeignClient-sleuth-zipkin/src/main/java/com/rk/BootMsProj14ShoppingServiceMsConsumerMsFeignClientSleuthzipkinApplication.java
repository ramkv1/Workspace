package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BootMsProj14ShoppingServiceMsConsumerMsFeignClientSleuthzipkinApplication {

	@Bean
	public Sampler createSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	public static void main(String[] args) {
		SpringApplication.run(BootMsProj14ShoppingServiceMsConsumerMsFeignClientSleuthzipkinApplication.class, args);
	}

}
