package com.rk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.ShoppingService;

public class AfterReturningAdviceTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get spring bean class object ref
		ShoppingService store=ctx.getBean("store",ShoppingService.class);
		//invoke the b.method
		try {
			double billamount=store.shopping(new String[] {"shirt", "trouser","shoe"},new double[] {9000.0,6000.0,4000.0});
			System.out.println("Bill amount::"+billamount);
		}catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}
}
