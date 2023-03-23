package com.rk.sbeans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("cktr")
public class Cricketer implements ApplicationContextAware {
	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext()");
		this.ctx=ctx;
		
	}
	
	public Cricketer() {
		System.out.println("Cricketer::0-param constructor");
	}
	public String batting() {
		//get Dependence spring bean class object
		CricketBat bat=ctx.getBean("cBat",CricketBat.class);
		//use the dependent object
		int runs=bat.scoreRuns();
		return "Cricketer is batting==>"+bat.scoreRuns();
	}
	public String bowling()
	{
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
		//get Dependence spring bean class object
		Fielding filed=ctx.getBean("sRuns",Fielding.class);
		//use the dependent object
		int sruns=filed.savedTheRuns();
		return "Cricketer is Saving the runs==>"+filed.savedTheRuns();
	}

}
