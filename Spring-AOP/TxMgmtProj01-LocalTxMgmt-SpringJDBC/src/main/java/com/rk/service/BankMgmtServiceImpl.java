package com.rk.service;

import com.rk.dao.IBankDAO;

public class BankMgmtServiceImpl implements IBankMgmtService {
	private IBankDAO dao;
	public BankMgmtServiceImpl(IBankDAO dao) {
		this.dao=dao;
	}
	
	@Override
	public String transferMoney(int srcAcno, int destAcno, Double amount) throws IllegalAccessException {
		/*		
				  try 
				  {
					  Thread.sleep(25000); 
				  } 
				  catch (Exception e) 
				  {
					  e.printStackTrace();
				  }//==>For transaction timeException
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
