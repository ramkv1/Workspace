package com.rk.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngg")
public class ElectricEngine implements Engine {
	
	public ElectricEngine(){
		System.out.println("ElectricEngine::0-Paramconstructor");
	}

	@Override
	public void start() {
		System.out.println("ElectricEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("ElectricEngine.run()");

	}

}
