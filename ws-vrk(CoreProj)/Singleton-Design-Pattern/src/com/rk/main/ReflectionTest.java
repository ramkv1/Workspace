package com.rk.main;

import java.lang.reflect.Constructor;

public class ReflectionTest {
	
	public static void main(String[] args) {
		Pen p1=Pen.getPen();
		try {
			System.out.println(p1);
			Class c=Class.forName("com.rk.main.Pen");
		Constructor con[]=c.getDeclaredConstructors();
		con[0].setAccessible(true);
		
			Pen p2=(Pen) con[0].newInstance();
			
			System.out.println(p1+"...."+p2);
			System.out.println((p1==p2)?"true  ":"false"+"p1==p2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
