package com.rk.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
@Lazy(true)
public class Cricketer {
	public Cricketer() {
		System.out.println("Cricketer::0-param constructor");
	}
	public String batting() {
		//Create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get Dependence spring bean class object
		CricketBat bat=ctx.getBean("cBat",CricketBat.class);
		//use the dependent object
		int runs=bat.scoreRuns();
		return "Cricketer is batting==>"+bat.scoreRuns();
	}
	public String bowling()
	{
		//Create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get Dependence spring bean class object
		Bowling boll=ctx.getBean("Bowl",Bowling.class);
		//use the dependent object
		int wkts=boll.takingWickets();
		return "Cricketer is takingWickets==>"+boll.takingWickets();
	}
	public String wicketkeeping() {
		return "cricketer is keeping the wickets";
		
	}
	public String fileding() {
		//Create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		//get Dependence spring bean class object
		Fielding filed=ctx.getBean("sRuns",Fielding.class);
		//use the dependent object
		int sruns=filed.savedTheRuns();
		return "Cricketer is Saving the runs==>"+filed.savedTheRuns();
	}
}
