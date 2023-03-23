package com.rk.sbeans;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component("sRuns")
public class Fielding {
	public Fielding() {
		
	}
	public int savedTheRuns() {
		return new Random().nextInt(15);
	}
}
