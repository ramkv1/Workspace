package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.sbeans.VotingElgibilityCheck;

public class SpringBeanLifecycleTest {
	
    public static void main( String[] args )
    {
    	//create IOC container
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
    	System.out.println("__________________________________");
    	//get spring bean class object
    	VotingElgibilityCheck vec=ctx.getBean("vec",VotingElgibilityCheck.class);
    	
    	try {
    		//Invoke the b,method
    		String result=vec.checkVotingElgibility();
    		System.out.println(result);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    	System.out.println("_____________________");
    	//close the IOC Container
    	ctx.close();
    }
}
