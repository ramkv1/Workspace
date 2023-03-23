package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.rk.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtProj06BootDistributedtxMgmtAtomokisApplication {

	public static void main(String[] args) {
		//create IOC Container
		ApplicationContext ctx=SpringApplication.run(TxMgmtProj06BootDistributedtxMgmtAtomokisApplication.class, args);
		//get proxy class Object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke the b.method
		try {
			System.out.println("Result::"+proxy.transferMoney(1001,1002,2000.0f));
		}
		catch (Exception se) {
			se.printStackTrace();
		}
		//close container
			((AbstractApplicationContext) ctx).close();
	
	}

}
