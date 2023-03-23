package com.rk.runners;

public class LambdaTest {
	public static void main(String[] args) {
		Arithemetic ar=(x,y)->{return (x+y);};
		System.out.println(ar.add(10, 20));
		System.err.println("______________________");
		Arithemetic ar1=(a,b)->a+b;
		System.out.println(ar1.add(50, 90));
	}
}
