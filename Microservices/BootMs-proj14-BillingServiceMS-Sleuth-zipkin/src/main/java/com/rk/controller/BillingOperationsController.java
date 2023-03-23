package com.rk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")

public class BillingOperationsController {
	private static Logger logger=LoggerFactory.getLogger(BillingOperationsController.class);
	
	@GetMapping("/info")
	public ResponseEntity<String> showPaymentModes(){
		logger.info("at beginging of showPayment() method---BillingService");
		ResponseEntity<String> entity=new ResponseEntity<String>("we accept URI payment/cardPayment/ NetBanking Payment/.. Form Instance::",HttpStatus.OK);
		logger.info("at end of showPayment() method---BillingService");
		return entity;
	}
}
