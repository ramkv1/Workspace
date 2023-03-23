package com.rk.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	//HAS_A property
	@Autowired
	@Qualifier("ldt1")
	private LocalDateTime dateTime;
	
	/*@Autowired
	public WishMessageGenerator(LocalDateTime dateTime) {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
		this.dateTime = dateTime;
	}*/


//	//setter method for setter Injection
//	@Autowired
//	public void setDateTime(LocalDateTime dateTime) {
//		System.out.println("WishMessageGenerator.setDateTime()");
//		this.dateTime = dateTime;
//	}
	
	//b.method
	public String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		//get current hour of the day
		int hour=dateTime.getHour();
		//generate current hour of the day
		if(hour<12)
			return "Good Morning:"+user;
		else if(hour<16)
			return "Good Afternoon"+user;
		else if(hour<20)
			return "Good Evening:"+user;
		else 
			return "Good Night:"+user;
		
	}
}