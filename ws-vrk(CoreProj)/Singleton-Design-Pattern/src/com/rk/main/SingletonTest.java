package com.rk.main;

public class SingletonTest {
	public static void main(String[] args)throws Exception{
		Pen p =Pen.getPen();
		SerializationAndDeserialization.getSerialization(p);
		Pen p1=SerializationAndDeserialization.getDeserialization();
		System.out.println("SingletonTest.main()");
		System.out.println(p+" "+p1);
		System.out.println(p.hashCode()+" "+p1.hashCode());
		System.out.println((p==p1)?"hashcodes same ":"different");
		Object o=p.clone();
		System.out.println((p==p1)?"hashcodes same ":"different");
		System.out.println(p+" "+p1);
			
			/*
			 * System.out.println(MySingleton.INSTANCE.hashCode());
			 * System.out.println(MySingleton.INSTANCE.hashCode());
			 * System.out.println(MySingleton.INSTANCE.hashCode());
			 */
		}
}
