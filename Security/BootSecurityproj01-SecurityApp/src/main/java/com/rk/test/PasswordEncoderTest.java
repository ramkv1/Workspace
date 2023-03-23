package com.rk.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	 public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("Rani"));
		System.out.println(encoder.encode("Hyd"));
		System.out.println(encoder.encode("Delhi"));
	}
}
