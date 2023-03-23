package com.rk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rk.entity.UserInfo;
import com.rk.service.IUserInfoService;

@Controller
@RequestMapping("/user")
public class UserOperationsController {
	@Autowired
	private IUserInfoService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/register")
	public String showUserRegistrationForm(@ModelAttribute("userInfo") UserInfo info) {
		return "user_register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo") UserInfo user,Map<String,Object>map ) {
		//encode the password
		String encode=encoder.encode(user.getPwd());
		//Save User
		String msg=userService.register(user);
		//keep msg in model attribute
		map.put("ResultMsg", msg);
		//return LVN
		return "User_Register_success";
	}
}
