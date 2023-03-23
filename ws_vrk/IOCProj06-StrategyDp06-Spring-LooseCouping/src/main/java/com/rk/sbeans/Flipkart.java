package com.rk.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	//Has-A property
	@Autowired
	@Qualifier("shipper")
	private Courier courier;
	
	//b.method
	public String shopping(String items[],double prices[]) {
		//calculate bill amount
		double billAmount=0.0;
		for(double p:prices) {
			billAmount=billAmount+p;
		}
		//To Generate the order id(random number as the order)
		int oid=new Random().nextInt(1000);
		
		String msg=courier.deliver(oid);
		
		return Arrays.toString(items)+" items with billAmount:::"+billAmount+"  "+msg;
	}
}
