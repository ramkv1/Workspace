package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtProj04BootLocaltxMgmtSpringJdbcApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(TxMgmtProj04BootLocaltxMgmtSpringJdbcApplication.class, args);
		// get service class Object
		IBankMgmtService proxy = ctx.getBean("bankService", IBankMgmtService.class);
		// Invoke the B,.method
		try {
			System.out.println(proxy.transferMoney(1001, 1002, 5000.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}
}
