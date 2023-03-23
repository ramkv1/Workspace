package com.rk.sbeans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("Bowl")
public class Bowling {
	public Bowling() {
		//System.out.println("Bowling::0-param constructor");
	}
	public int takingWickets() {
		return new Random().nextInt(5);
	}
}
