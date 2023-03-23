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
	
	@Around("execution(double com.rk.service.IBankService.*(..))")
	public Object performence(ProceedingJoinPoint pjp)throws Throwable {
		//pre logics
		start=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has entered int b.method at"+new Date());
		//invoke b.method/target method
		Object args[]=pjp.getArgs();
		if(((double)args[0])<=50000)
			args[1]=((Double)args[1])-0.5;
		//Controlling the target method execution
		if(((double)args[0])<0||((Double)args[1])<=0||((double)args[2])<=0)
			throw new IllegalArgumentException("Invalid Argument value");
		//invoke b.method/target method
		Object retVal=pjp.proceed(args);
		//post logic
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has exited from the b.method at"+new Date());
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has taken"+(end-start)+"ms to complete execution");
		//modying the return value.
		retVal=(double)retVal+(Double)retVal*0.18;
	return retVal;
	}
}
