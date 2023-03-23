package com.rk.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart{

	private Courier courier;
	
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier()");
		this.courier=courier;
	}
	//b.method
	public String shopping(String items[],double prices[]) {
		//calculate bill amount
		double billAmount=0.0;
		for(double p:prices) {
			billAmount=billAmount+p;
		}
		//genarate the order id(random number as the order)
		int oid=new Random().nextInt(1000);
		//deliver the product using courier
		String msg=courier.deliver(oid);
		
		return Arrays.toString(items)+" item with billAmount::::"+billAmount+"----"+msg;
		
	}

}
