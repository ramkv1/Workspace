package com.rk.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create testTemplate class object
		RestTemplate template=new RestTemplate();
		String baseUrl="http://localhost:8080/BootRestProj12-ActorService-API/actor/wish";
		ResponseEntity<String> response=template.getForEntity(baseUrl,String.class);
		System.out.println("response body::"+response.getBody());
		System.out.println("response status::"+response.getStatusCode());
	}

}
