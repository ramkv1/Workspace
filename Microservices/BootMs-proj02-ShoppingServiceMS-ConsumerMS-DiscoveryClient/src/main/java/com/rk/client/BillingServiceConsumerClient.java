package com.rk.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BillingServiceConsumerClient {
	@Autowired
	private DiscoveryClient client;
	
	public ResponseEntity<String> getBillingDetails() {
		//get provider Ms (BillingService) Service instances
		List<ServiceInstance> listSI=client.getInstances("Billing-Service");
		//get access to specific service instance of provider Ms
		ServiceInstance SI=listSI.get(0);
		//gather details from service Instance(producer Ms)
		URI uri=SI.getUri();
		//prepaire complete URL (URL+path)
		String url=uri+"/billing/info";
		//Create RestTemplate Object
		RestTemplate template=new RestTemplate();
		//consume the Provider MS Service
		ResponseEntity<String> entity=template.getForEntity(url,String.class);
		return entity;
	}
}
