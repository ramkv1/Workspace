//AwareInjectionDependencyLookupTest
package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.sbeans.Cricketer;

public class AwareInjectionDependencyLookupTest {
	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get  target spring bean class obj
		Cricketer cktr=ctx.getBean("cktr",Cricketer.class);
		//invoke b.method
		System.out.println(cktr.batting());
		System.out.println(cktr.bowling());
		System.out.println(cktr.fileding());
		//close the container
		ctx.close();
		
	}
}
