package com.rk.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class YTestCmdLineRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("______________________________-");
		System.out.println("YTestCmdLineRunner.run()");
		System.out.println("Command args are::"+Arrays.toString(args));
		int a=10;
		System.out.println("Square value::"+(a*a));
	}

	@Override
	public int getOrder() {
		return -7;
	}

}
