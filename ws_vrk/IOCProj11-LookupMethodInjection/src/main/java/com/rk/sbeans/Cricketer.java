package com.rk.sbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("cktr")
public abstract class Cricketer{
	public Cricketer() {
		System.out.println("Cricketer::0-Paramconstructor");
	}
	
	@Lookup
	public abstract CricketBat getBat();
	@Lookup
	public abstract Bowling getBall();
	@Lookup
	public abstract Fielding field();
	
	public String batting() {
		//get Dependent class Object
		CricketBat bat=getBat();
		//use the dependent object
		int runs=bat.scoreRuns();
		return "Cricketer is Scoring Runs==>"+bat.scoreRuns();
	}
	public String bowling()
	{
		Bowling bowl=getBall();
		//use the dependent object
		int wkts=bowl.takingWickets();
		return "Cricketer is takingWickets==>"+bowl.takingWickets();
	}
	public String wicketkeeping() {
		return "cricketer is keeping the wickets";
		
	}
	public String fileding() {
		Fielding field=field();
		//use the dependent object
		int sruns=field.savedTheRuns();
		return "Cricketer is Saving the runs==>"+field.savedTheRuns();
	}

}
