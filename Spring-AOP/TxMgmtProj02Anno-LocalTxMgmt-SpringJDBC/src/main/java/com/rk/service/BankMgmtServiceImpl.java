package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private IBankDAO dao;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = IllegalArgumentException.class)
	public String transferMoney(int srcAcno, int destAcno, Double amount) throws IllegalAccessException {
		/*
		 * try { Thread.sleep(25000); } catch (Exception e) { e.printStackTrace(); }//==>For transaction timeException
		 */
		int count1=dao.deposite(destAcno, amount);
		int count2=dao.withdraw(srcAcno, amount);
		if(count1==0 || count2==0)
			//throw new RuntimeException("Tx rolled back ---->money is not transfered");
			throw new IllegalAccessException("Tx rolled back ---->money is not transfered");
		else
			return "Tx committed.. Money Transfered";
	}

}
