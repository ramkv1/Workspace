package com.rk.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCosumerAppRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:8080/BootRestProj14-ActorService-API-Post-JsonBody/actor/register";
	
		//prepare json bidy
		String actor_json_body="{\"actorId\":5001,\"actorName\":\"raja\",\"actorAddrs\":\"hyd\",\"renumeration\":8000}";
	
		//prepare http headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//prepare request object in the form of httpEntity object having body and headers
		HttpEntity<String> request=new HttpEntity<String>(actor_json_body,headers);
		
		//invoke operation/service of provider app using POST mode
		ResponseEntity<String> response=template.postForEntity(baseUrl, request, String.class);
		System.out.println("________________________________________________________________________");
		
		System.out.println("response body::"+response.getBody());
		System.out.println("response status::"+response.getStatusCode().toString());
		System.out.println("response headers are::"+response.getHeaders().toString());
		System.out.println("Status code value::"+response.getStatusCode().value());
		
		System.out.println("________________________________________________________________________");
	}

}
