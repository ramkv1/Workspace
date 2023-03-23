package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ActorServiceCosumerAppRunner5 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			String baseURL="http://localhost:8080/BootRestProj14-ActorService-API-Post-JsonBody/actor/report/{id}";
			//invoke the service
			ResponseEntity<String> response=template.exchange(baseURL,HttpMethod.GET, null,String.class,101);
			//display result
			System.out.println("response body(result)"+response.getBody());
			System.out.println("response status code::"+response.getStatusCode());
			System.out.println("____________________________");
//			//converting json response body to java class object using JACKSON API
//			ObjectMapper mapper=new ObjectMapper();
//			Actor actor=mapper.readValue(response.getBody(), Actor.class);
//			System.out.println("Actor Object data::"+actor);
//			
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+"problem");
		}
	}

}
