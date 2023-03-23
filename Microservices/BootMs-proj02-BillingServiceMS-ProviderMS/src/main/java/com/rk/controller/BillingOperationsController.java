package com.rk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingOperationsController {
	
	
	@GetMapping("/info")
	public ResponseEntity<String> showPaymentModes(){
		return new ResponseEntity<String>("we accept URI payment/cardPayment/ NetBanking Payment/..",HttpStatus.OK);
	}
}
