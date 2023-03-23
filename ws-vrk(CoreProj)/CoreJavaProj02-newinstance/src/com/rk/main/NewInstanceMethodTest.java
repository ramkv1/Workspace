package com.rk.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class NewInstanceMethodTest {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName(args[0]);
		Constructor cons[]=c.getDeclaredConstructors();
		Object obj1=cons[0].newInstance();
		System.out.println(obj1.toString());
		System.out.println("==================");
		Object obj2=cons[1].newInstance(10,20);
		//System.out.println(obj2.toString());
		
		Field field[]=obj2.getClass().getDeclaredFields();
		field[0].setAccessible(true);
		field[1].setAccessible(true);
		
		System.out.println(field[0].getInt(obj2));
		System.out.println(field[1].getInt(obj2));
		field[0].setInt(obj2, 2000);
		field[1].setInt(obj2, 5000);
		System.out.println(obj2.toString());
		
	}
}

