package com.rk.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("pmAspect")
@Aspect
public class PerformenceMonitoringAspect {
	private long start,end;
	
	//@Around("execution(double com.nt.service.BankService.*(..))")
	@Around("execution(double com.rk.service.BankService.*(..))")
	public Object performence(ProceedingJoinPoint pjp)throws Throwable {
		//pre logics
		start=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has entered int b.method at"+new Date());
		//change b.method arg values
		Object args[]=pjp.getArgs();
		if((Double)args[0]<=50000)
			args[1]=((Double)args[1])-0.5;
		//controller the target method execution
		if(((Double)args[0])<=0||((Double)args[1])<=0||((Double)args[2])<0)
			throw new IllegalAccessException("Invalid argument value");
		//invoke b.method/target method
		Object retVal=pjp.proceed();
		//post logic
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has exited from the b.method at"+new Date());
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has taken"+(end-start)+"ms to complete execution");
		//modify the return value
		retVal=(Double)retVal+(double)retVal*0.18;				
		return retVal;
	}
}
