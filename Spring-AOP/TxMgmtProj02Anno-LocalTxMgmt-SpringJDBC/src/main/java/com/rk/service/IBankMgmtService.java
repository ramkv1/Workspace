package com.rk.service;

public interface IBankMgmtService {
	public String transferMoney(int srcAcno,int destAcno,Double amount) throws IllegalAccessException;
}
