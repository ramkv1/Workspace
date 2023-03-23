package com.rk.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class VotingElgibilityCheck {
	//spring bean properties
	private String name;
	private int age;
	private Date verifiedOn;
	
	public VotingElgibilityCheck() {
		System.out.println("VotingElgibilityCheck::0-param constructor");
	}
	public void setName(String name) {
		System.out.println("VotingElgibilityCheck.setName()");
		this.name=name;
	}
	public void setAge(int age) {
		System.out.println("VotingElgibilityCheck.setAge()");
		this.age=age;
	}
	public void setVerifiedOn(Date verifiedOn) {
		System.out.println("VotingElgibilityCheck.setVerifiedOn()");
		this.verifiedOn=verifiedOn;
	}
	
	public String checkVotingElgibility() {
		System.out.println("VotingElgibilityCheck.checkVotingElgibility()(Business Method)");
		if(age<18) {
			return "Mr/Mrs/Miss"+name+" u r not eligible for voting on date"+verifiedOn;
		}
		else {
			return "Mr/Mrs/Miss"+name+" u r not eligible for voting on date"+verifiedOn;
		}
		

	}
	@PostConstruct
	public void myInit() {
		System.out.println("VotingElgibilityCheck.myInit()");
		//initialize the left over properties
		verifiedOn=new Date();
		//check wheather important properties are cfg with correct value or not
		if(name==null || name.trim().length()==0 || age<=0)
			throw new IllegalArgumentException("Invalid values are injected for spring bean propertes(name,age");
	}
	@PreDestroy
	public void myDestory() {
		System.out.println("VotingElgibilityCheck.myDestory()");
		//nullify the spring bean properties
		name=null;
		age=0;
	}
}
