package com.rk.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BillingServiceConsumerClient {
	@Autowired
	private LoadBalancerClient client;
	
	public ResponseEntity<String> getBillingDetails() {
		//get provider Ms Less Load Factor Service instances
		ServiceInstance SI=client.choose("Billing-Service");
		//gather details from service Instance(producer Ms)
		URI uri=SI.getUri();
		//prepaire complete URL (URL+path)
		String url=uri+"/billing/api/info";
		//Create RestTemplate Object
		RestTemplate template=new RestTemplate();
		//consume the Provider MS Service
		ResponseEntity<String> entity=template.getForEntity(url,String.class);
		return entity;
	}
}
