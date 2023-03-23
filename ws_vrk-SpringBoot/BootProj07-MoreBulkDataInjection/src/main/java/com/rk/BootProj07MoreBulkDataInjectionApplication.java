package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.sbeans.Employee;

@SpringBootApplication
public class BootProj07MoreBulkDataInjectionApplication {

	public static void main(String[] args) {
		//Get Ioc Container
		ApplicationContext ctx=SpringApplication.run(BootProj07MoreBulkDataInjectionApplication.class, args);
		//Get Employee Spring bean class Object
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
		
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
