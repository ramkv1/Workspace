package com.rk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.BankService;

public class AroundAdviceTest 
{
    public static void main( String[] args )
    {
        //Create IOC Container 
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
    	//get Proxy class Object
    	BankService service=ctx.getBean("bankService",BankService.class);
    	System.out.println(service.getClass()+"----"+service.getClass().getSuperclass());
    	//invoke the b.method
    	try {
    		System.out.println("Simple Intrest Amount::"+service.calcSimpleIntrestAmount(100000.0, 2.0, 12.0));
    		System.out.println("-------------------------------");
    		System.out.println("Compound Intrest Amount::"+service.calcCompoundIntrestAmount(100000.0, 2.0, 12.0));
    	}//try
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	//close IOC Container
    	ctx.close();
    }//main
}//class
