package com.rk.service;

import org.springframework.stereotype.Component;

@Component("store")
public class ShoppingService {
	public double shopping(String items[],double price[]) {
		//calculate bill amount
		double billAmt=0.0;
		for(double p:price) {
			billAmt=billAmt+p;
		}
		return billAmt;
	}
}
