package com.rk.main;

import com.rk.comps.Bike;
import com.rk.factory.BikeFactory;

public class FactoryPatternTest {
	public static void main(String[] args) {
		Bike bike=BikeFactory.orderBike("standard");
		bike.drive();
		System.out.println("========================");
		Bike bike1=BikeFactory.orderBike("sports");
		bike1.drive();
		System.out.println("========================");
		Bike bike2=BikeFactory.orderBike("electric");
		bike2.drive();
		System.out.println("====================");
		Bike bike3=BikeFactory.orderBike("Bullet");
		bike3.drive();
		
	}
}
