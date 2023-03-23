package com.rk.service;

public class LoginService 
{
   public String login(String username,String password) {
		if((username==null || username.length()==0) || (password==null || password.length()==0))
		 throw new IllegalArgumentException("invalid inputs");
	   
	   
	   if(username.equalsIgnoreCase("raja")&& password.equalsIgnoreCase("rani"))
		   return "valid Credentials";
	   else
		   return "Invalid Credentials";
   }
}
