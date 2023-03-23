package com.rk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.config.AppConfig;
import com.rk.sbeans.Flipkart;

public class StrategyDPTest {
	public static void main(String[] args) {
		
//		  FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext(
//		  "src/main/java/com/rk/cfgs/applicationContext.xml");
		 
			AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
			  
		Object obj=ctx.getBean("fpkt");
		Flipkart fpkt=(Flipkart) obj;
		
		String result=fpkt.shopping(new String[] {"shirt","trouser"},new double[] {4000.0,6000.0});
		System.out.println(result);
		ctx.close();
	}
}
