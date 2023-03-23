package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.BankOperationService;

public class MethodReplacerTest {
	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get Target spring bean class Object
		BankOperationService proxy=ctx.getBean("bankService",BankOperationService.class);
		System.out.println(proxy.getClass()+"=======>"+proxy.getClass().getSuperclass());
		//invoke the b.method
		try {
			double intrAmt=proxy.calculateIntrestAmount(100000.0,2, 12.0);
			System.out.println("Intrest amount is::"+intrAmt);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		ctx.close();
	}
}
