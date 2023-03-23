package com.rk.comp;

public class Test {
	private int a;
	private int b;
	
	public Test() {
		System.out.println("Test::0-param constructor)");
	}
	public Test(int x,int y) {
		System.out.println("Test::2-Param Constructor");
		this.a=x;
		this.b=y;
	}
	
	//Tostring() method
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	
	
	
}

