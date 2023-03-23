package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("_____________________________");
		//create testTemplate class object
		
		String baseUrl="http://localhost:8080/BootRestProj13-ActorService-API-PathVariable/actor/wish/{id}/{name}";
		//invoke the service/operation of provider app
		String result=template.getForObject(baseUrl, String.class,101,"raja");
		System.out.println("result::"+result);
	}

}
