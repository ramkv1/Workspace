package com.rk.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "Show_Offers";
	}
	
	@GetMapping("/balance")
	public String showBalance(Map<String,Object> map)
	{
		map.put("account_balance",new Random().nextInt(10000000));
		return "show_balance";
	}
	
	@GetMapping("/loan")
	public String approvaBalance(Map<String,Object> map)
	{
		map.put("loan_amount",new Random().nextInt(1000));
		return "loan_approve";
	}
	@GetMapping("/denied")
	public String accessDeniedPage()
	{
		return "authorization_failed";
	}
}
