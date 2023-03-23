package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner2 implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args)throws Exception{
		String baseURL="http://localhost:8080/BootRestProj14-ActorService-API-Post-JsonBody/actor/wish";
		//invoke the Service
		ResponseEntity<String> response=template.exchange(baseURL,HttpMethod.GET, null,String.class);
		
		//dispay result
		System.out.println("response body(result)"+response.getBody());
		System.out.println("response status code::"+response.getStatusCode().value());
		System.out.println("________________________________________________________________________");
	}
}
