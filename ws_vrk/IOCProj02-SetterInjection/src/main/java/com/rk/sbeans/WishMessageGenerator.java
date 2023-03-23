package com.rk.sbeans;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	//HAS_A property
	
	private LocalDateTime dateTime;
	private Date date;
	
	/*
	  ////========Arbitary method Injection======
	  
	  @Autowired public void put1(LocalDateTime dateTime) {
	  System.out.println("WishMessageGenerator.put1()"); this.dateTime=dateTime; }
	  public void assign2(Date date) {
	  System.out.println("WishMessageGenerator.assign2()"); this.date=date; }
	*/ 
	
	
	/////===================Field Injection===============================

	/* @Autowired
	 * private LocalDateTime dateTime;
	 * 
	 * @Autowired
	 * private Date date;
	 */
	
	/////==============Constructor Injection===========================
	/*
	  @Autowired
	  public WishMessageGenerator(LocalDateTime dateTime,Date date) {
	  System.out.println("WishMessageGenerator-2Paramconstructor");
	  this.dateTime=dateTime; this.date=date; }
	 */ 
	/////  ================Setter Injection=====================
	 
	/*
	  @Autowired
	  public void setDateTime(LocalDateTime dateTime) {
	  System.out.println("WishMessageGenerator.setDateTime()"); this.dateTime =
	  dateTime; }
	  
	  @Autowired public void setDate(Date date) {
	  System.out.println("WishMessageGenerator.setDate()"); this.date = date; }
	 */
	 

	
	
	//b.method
	public String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		System.out.println("dateTime::"+dateTime+" date::"+date);
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
