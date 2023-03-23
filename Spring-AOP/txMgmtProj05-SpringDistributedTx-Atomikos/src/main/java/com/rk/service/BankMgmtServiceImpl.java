package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.IDepositeDAO;
import com.rk.dao.IWithdrawDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private IWithdrawDAO wDAO;
	@Autowired
	private IDepositeDAO dDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String transferMoney(long srcAcno, long destAcno, double amount) {
		//perform withDraw Operation
		int count1=wDAO.withdraw(srcAcno, amount);
		int count2=dDAO.Deposite(destAcno, amount);
		if(count1==count2)
			throw new RuntimeException("tx...rolledl back-Money not transfered");
		return "tx..committed-Money transfered";
	}

}
