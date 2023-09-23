package com.rk.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
	
@Order(1)
public class ATestApplicationRunner implements ApplicationRunner,Ordered {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("_______________________");
		System.out.println("ATestApplicationRunner.run()");
		System.out.println("Non-Optional args::"+args.getNonOptionArgs());
		System.out.println("Optional args names and values");
		for(String name:args.getOptionNames()) {
			System.out.println(name+"........"+args.getOptionValues(name));
		}
		
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 20;
	}
	
}
