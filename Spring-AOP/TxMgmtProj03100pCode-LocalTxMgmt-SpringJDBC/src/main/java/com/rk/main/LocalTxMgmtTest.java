package com.rk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk.config.AppConfig;
import com.rk.service.IBankMgmtService;

public class LocalTxMgmtTest {
	public static void main(String[] args) {
		//Create IOC Container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//Get Service class Object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//Invoke the B.method
		try {
			System.out.println(proxy.transferMoney(1001, 1002, 5000.0));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		ctx.close();
	}
}
