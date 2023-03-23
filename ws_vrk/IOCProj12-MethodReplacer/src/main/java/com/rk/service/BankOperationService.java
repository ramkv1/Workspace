package com.rk.service;

import org.springframework.stereotype.Component;

//@Component("bankService")
public class BankOperationService {
	public double calculateIntrestAmount(double pamt,double rate,double time) {
		System.out.println("BankOperationService.calculateIntrstAmount()(Compound Intrest)");
		return (pamt*Math.pow(1+rate/100, time))-pamt;
	}
}
