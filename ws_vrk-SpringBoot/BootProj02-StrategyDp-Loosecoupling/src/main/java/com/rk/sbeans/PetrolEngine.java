package com.rk.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngg")
public class PetrolEngine implements Engine {
	
	public PetrolEngine(){
		System.out.println("PetrolEngine::0-Paramconstructor");
	}

	@Override
	public void start() {
		System.out.println("PetrolEngine.start()");
 
	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.run()");

	}

}
