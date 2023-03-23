package com.rk.factory;

import com.rk.comp.BlueDart;
import com.rk.comp.Courier;
import com.rk.comp.DTDC;
import com.rk.comp.Flipkart;

public class FlipkartFactory {
	//static factory method having factory pattern logic
	public static Flipkart getInstance(String courierType) {
		//create Dependent class obj
		Courier courier=null;
		if(courierType.equalsIgnoreCase("dtdc"))
			courier=new DTDC();
		else if(courierType.equalsIgnoreCase("blueDart"))
			courier=new BlueDart();
		else {
			throw new IllegalArgumentException("invalid courier Type");
		}
		//create target class obj
		Flipkart fpkt=new Flipkart();
		fpkt.setCourier(courier);
		
		return fpkt;
	}
}
