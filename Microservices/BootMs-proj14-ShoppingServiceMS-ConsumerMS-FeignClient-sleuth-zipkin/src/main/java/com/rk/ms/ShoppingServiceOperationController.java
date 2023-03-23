package com.rk.ms;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger=LoggerFactory.getLogger(ShoppingServiceOperationController.class);
	
	@GetMapping("/details")
	public ResponseEntity<String> showBillingDetails(){
		logger.info("at end beginging of showBillingDetails()--ShoppingService");
		System.out.println(client.getClass()+"....."+Arrays.toString(client.getClass().getInterfaces()));
		logger.info("before calling provider MS");
		//use Client comp support to invoke provider Ms service
		ResponseEntity<String> entity=client.getBillingInfo();
		String resultBody=entity.getBody(); //provider MS result
		logger.info("before calling provider MS");
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return ResponseEntity<String> Object from Consumer MS
		String billInfo="Bill amount::"+new Random().nextInt(100000);//Consumer MS Result
		logger.info("at the end of showBillingDetails()--Shopping");
		return new ResponseEntity<String>(billInfo+"....."+resultBody,HttpStatus.OK);
	}
}
