package com.rk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepositeDAOImpl implements IDepositeDAO{
	private static final String DEPOSITE_QUERY="UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";

	
	@Autowired
	@Qualifier("mysqlJT")
	private JdbcTemplate jt;
	
	
	@Override
	public int Deposite(long accno, double amount) {
		int count1=jt.update(DEPOSITE_QUERY,amount,accno);
		return count1;
	}

}
