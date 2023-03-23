package com.rk.factory;

import com.rk.comps.Bike;
import com.rk.comps.BulletBike;
import com.rk.comps.ElectricBike;
import com.rk.comps.SportsBike;
import com.rk.comps.StandardBike;

public class BikeFactory {
	//static factory method having factory pattern logic
	public static Bike orderBike(String type) {
		Bike bike=null;
		if(type.equalsIgnoreCase("standard")) {
			bike=new StandardBike();
		}
		else if (type.equalsIgnoreCase("sports")) {
			bike=new SportsBike();
		}
		else if (type.equalsIgnoreCase("electric")) {
			bike=new ElectricBike();
		}
		else if (type.equalsIgnoreCase("bullet")) {
			bike=new BulletBike();
		}
		else {
			throw new IllegalArgumentException("Invalid bike type");
		}
		return bike;
	}
}
