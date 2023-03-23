package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootkafkaProj03ProducerAndConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootkafkaProj03ProducerAndConsumerApplication.class, args);
	}

}
