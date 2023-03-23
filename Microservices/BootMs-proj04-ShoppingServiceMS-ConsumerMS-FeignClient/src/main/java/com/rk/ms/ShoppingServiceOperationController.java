package com.rk.ms;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationController {
	@Autowired
	private IBillingServiceRestConsumer client;
	
	@GetMapping("/details")
	public ResponseEntity<String> showBillingDetails(){
		System.out.println(client.getClass()+"....."+Arrays.toString(client.getClass().getInterfaces()));
		//use Client comp support to invoke provider Ms service
		ResponseEntity<String> entity=client.getBillingInfo();
		String resultBody=entity.getBody(); //provider MS result
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return ResponseEntity<String> Object from Consumer MS
		String billInfo="Bill amount::"+new Random().nextInt(100000);//Consumer MS Result
		return new ResponseEntity<String>(billInfo+"....."+resultBody,HttpStatus.OK);
	}
}
