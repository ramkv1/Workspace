package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.model.CustomerInfo;

@SpringBootApplication
public class BootProj08DataInjectionYmlApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj08DataInjectionYmlApplication.class, args);
		//get Spring bean class Object
		CustomerInfo custInfo=ctx.getBean("cust",CustomerInfo.class);
		System.out.println(custInfo);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
