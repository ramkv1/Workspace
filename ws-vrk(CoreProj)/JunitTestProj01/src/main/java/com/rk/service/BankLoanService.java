package com.rk.service;

public class BankLoanService{
	public float calSimpleIntrestAmount(float pAmt,float rate,float time) {
		//System.out.println("BankLoanService.calSimpleIntrestAmount(-,-,-)");
		if(pAmt<=0 || rate<=0 || time<=0 )
			throw new IllegalArgumentException("Invalid Inputs");
		
		return pAmt*rate*time/100.0f;
	}
}
