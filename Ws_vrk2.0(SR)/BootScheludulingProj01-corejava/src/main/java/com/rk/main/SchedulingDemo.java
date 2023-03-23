package com.rk.main;

import java.util.Date;
import java.util.Timer;

import com.rk.Job.Task1;

public class SchedulingDemo {
	public static void main(String[] args) {
		System.out.println("SchedulingDemo.main()-start::App is srated at::"+new Date());
		Timer timer=new Timer();
		//timer.schedule(new Task1(), 2000,3000);
		timer.schedule(new Task1(),new Date(122,10,11,11,23,50));
		System.out.println("SchedulingDemo.main()-end:: App is Ended ar::"+new Date());
	}
}
