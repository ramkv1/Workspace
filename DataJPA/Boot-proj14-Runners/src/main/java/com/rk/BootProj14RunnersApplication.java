package com.rk;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj14RunnersApplication {

		@Bean
		@Order(20)
		public CommandLineRunner createCmdRunner1() {
			System.out.println("BootProj14RunnersApplication.createCmdRunner1()");
			/*	CommandLineRunner cmd=args->{
					System.out.println("_____________________________");
					System.out.println(Arrays.toString(args));
				};*/
			CommandLineRunner cmd=args->Arrays.toString(args);
			return cmd;
		}
	
	/*@Bean
	public ApplicationRunner createAppRunner() {
		ApplicationRunner apt=args->{
			System.out.println(args);
		};
		return apt;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(BootProj14RunnersApplication.class, args);
	}

}
