package com.rk.main;

public class Printer{
	private static Printer INSATANCE=new Printer();
	private Printer() {
	}
	
	public static Printer getInstance() {
		return INSATANCE;
	}
}