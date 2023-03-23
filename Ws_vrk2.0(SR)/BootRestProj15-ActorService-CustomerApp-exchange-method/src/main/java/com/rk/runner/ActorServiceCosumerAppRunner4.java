package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner4 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			String baseURL="http://localhost:8080/BootRestProj14-ActorService-API-Post-JsonBody/actor/wish/{id}";
			//invoke the service
			ResponseEntity<String> response=template.exchange(baseURL,HttpMethod.DELETE, null,String.class,101);
			//display result
			System.out.println("response body(result)"+response.getBody());
			System.out.println("response status code::"+response.getStatusCode());
			System.out.println("____________________________");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+"problem");
		}
	}

}
