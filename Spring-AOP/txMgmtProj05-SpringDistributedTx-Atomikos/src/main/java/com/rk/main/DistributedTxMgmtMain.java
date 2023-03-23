package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.IBankMgmtService;

public class DistributedTxMgmtMain {
	public static void main(String[] args) {
		//create IOC COmtainer
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get proxy class Object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke the b.method
		try {
			proxy.transferMoney(1001,1002,2000.0f);
		}
		catch (Exception se) {
			se.printStackTrace();
		}
		//close container
		ctx.close();
	}//method
}//class
