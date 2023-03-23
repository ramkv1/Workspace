package com.rk.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//create testTemplate class object
		
		String baseUrl="http://localhost:8080/BootRestProj13-ActorService-API-PathVariable/actor/wish/{id}/{name}";
		/*		ResponseEntity<String> response=template.getForEntity(baseUrl,String.class,101,"raja");
				System.out.println("response body::"+response.getBody());
				System.out.println("response status::"+response.getStatusCode());*/
		ResponseEntity<String> response=template.getForEntity(baseUrl, String.class,Map.of("name","rajesh","id",500001));
		System.out.println("response body::"+response.getBody());
		System.out.println("response status::"+response.getStatusCode().toString());
		System.out.println("response headers are::"+response.getHeaders().toString());
		System.out.println("Status code value::"+response.getStatusCode().value());
	}

}
