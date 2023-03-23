package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.sbeans.Vehicle;

@SpringBootApplication
public class BootProj02StrategyDpApplication {

	public static void main(String[] args) {
		//Create Ioc Container
		ApplicationContext ctx=SpringApplication.run(BootProj02StrategyDpApplication.class, args);
		//Get Target spring beanClass Object
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//Invoke the b.method
		vehicle.move("hyderabad","Goa");
		//Close container
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
