package com.rk.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserOperationController {
	
	@GetMapping("/home")
	public String showHomePage() {
		return "Hello,Welcome to home page of RedBus.com";
	}
	@GetMapping("/after")
	public String afterloginPage() {
		return "Hello ,You Successfully Logged into RedBus.com";
	}
	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		System.out.println("Logged in Details::"+principal.getName());
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
}
