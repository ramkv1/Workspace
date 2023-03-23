package com.rk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk.config.AppConfig;
import com.rk.sbeans.WishMessageGenerator;

public class AutoWiringTest {
	public static void main(String[] args) {
		//create IOC Container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("__________________________________");
		//get spring bean class object ref
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println("__________________________________");
		//invoke the b.method
		String resultMsg=generator.generateWishMessage("raja");
		System.out.println(resultMsg);
		System.out.println("__________________________________");

//		LocalDateTime dtTime=ctx.getBean("createLDT",LocalDateTime.class);
//		System.out.println(dtTime);
		String beansids[]=ctx.getBeanDefinitionNames();
		System.out.println("Spring breans count::"+ctx.getBeanDefinitionCount());
		System.out.println("Singleton scope spring beans are");
		for(String id:beansids) {
			if(ctx.isSingleton(id)) {
				System.out.println(id);
			}
		}
		System.out.println();
		//close the container
		ctx.close();
	}
}
