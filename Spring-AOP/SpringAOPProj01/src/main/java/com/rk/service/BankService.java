package com.rk.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public class BankService{
	public double calcSimpleIntrestAmount(double pamt,double rate,double time) {
		System.out.println("BankService.calcSimpleIntrestAmount()");
		return pamt*rate*time/100.0;
	}
	public double calcCompoundIntrestAmount(double pamt,double rate,double time) {
		System.out.println("BankService.calcSimpleIntrestAmount()");
		return (pamt*1+Math.pow(1+rate/100, time))-pamt;
	}
}
