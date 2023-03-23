package com.rk;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.rk.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	@Bean(name="Id")
	public LocalDate createDate() {
		return LocalDate.now();
	}

	public static void main(String[] args) {
		//Get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//get Target spring bean class object
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.method
		String seasonName=finder.findSeason();
		System.out.println("Season Name=======>"+seasonName);
		
		System.out.println("SpringBean Count"+ctx.getBeanDefinitionCount());
		String id[]=ctx.getBeanDefinitionNames();
		for(String a:id) {
			System.out.println(a);
		}
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
