package com.rk.main;

import com.rk.comp.Flipkart;
import com.rk.factory.FlipkartFactory;

public class StrategePatternTest {
	public static void main(String[] args) {
		Flipkart fpkt=FlipkartFactory.getInstance("dtdc");
		
		String resultMsg=fpkt.shopping(new String[] {"shirt","trouser"}, new double[] {5000.0,6000.0});
		
		System.out.println(resultMsg);
	}
}
