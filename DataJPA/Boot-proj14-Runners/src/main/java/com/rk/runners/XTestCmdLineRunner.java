package com.rk.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(7)
public class XTestCmdLineRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("______________________");
		System.out.println("XTestCmdLineRunner.run()");
		System.out.println("Command args are::"+Arrays.toString(args));
		int a=10;
		System.out.println("Square value::"+(a*a));
	}

	@Override
	public int getOrder() {
		return 2;
	}

}
