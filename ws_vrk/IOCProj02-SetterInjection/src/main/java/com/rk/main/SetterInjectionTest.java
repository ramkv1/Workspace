package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.sbeans.WishMessageGenerator;

public class SetterInjectionTest {
	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main()");
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get target spring bean class obj
		Object obj=ctx.getBean("wmg");
		//type Casting
		WishMessageGenerator generator=(WishMessageGenerator) obj;
		//Invoke the b.method
		String result=generator.showWishMessage("Raja");
		//display the result
		System.out.println(result);
		//close container
		ctx.close();
		
		
		System.out.println("SetterInjectionTest.main()");
	}
}
