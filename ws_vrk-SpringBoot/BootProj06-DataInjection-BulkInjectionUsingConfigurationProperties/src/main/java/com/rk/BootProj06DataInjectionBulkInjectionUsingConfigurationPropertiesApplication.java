package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.sbeans.Company1;
import com.rk.sbeans.Company2;

@SpringBootApplication
public class BootProj06DataInjectionBulkInjectionUsingConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj06DataInjectionBulkInjectionUsingConfigurationPropertiesApplication.class, args);
		
		Company1 company1=ctx.getBean("comp1",Company1.class);
		System.out.println(company1);
		System.out.println("======================================");
		Company2 company2=ctx.getBean("comp2",Company2.class);
		System.out.println(company2);
		//System.out.println("system properties are::"+System.getProperties());
		((ConfigurableApplicationContext) ctx).close();
	}

}
