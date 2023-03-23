package com.rk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")

public class BillingOperationsController {
	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String InstanceId;
	@GetMapping("/info")
	public ResponseEntity<String> showPaymentModes(){
		ResponseEntity<String> entity=new ResponseEntity<String>("we accept URI payment/cardPayment/ NetBanking Payment/.. PortNumber"+port+"InstanceId"+InstanceId,HttpStatus.OK);
		return entity;
	}
}
