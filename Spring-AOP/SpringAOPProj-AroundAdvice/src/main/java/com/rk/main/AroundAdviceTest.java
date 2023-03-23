package com.rk.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.IBankService;

public class AroundAdviceTest 
{
    public static void main( String[] args )
    {
        //Create IOC Container 
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
    	//get Proxy class Object
    	IBankService service=ctx.getBean("bankService",IBankService.class);
    	System.out.println(service.getClass()+"----"+service.getClass().getSuperclass()+"..."+Arrays.toString(service.getClass().getInterfaces()));
    	//invoke the b.method
    	try {
    		System.out.println("Simple Intrest Amount::"+service.calcSimpleIntrestAmount(50000.0, 2.0, 12.0));
    	}//try
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("-------------------------------");
		try {
    	System.out.println("Compound Intrest Amount::"+service.calcCompoundIntrestAmount(50000.0, 2.0, 12.0));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    	//close IOC Container
    	ctx.close();
    }//main
}//class
