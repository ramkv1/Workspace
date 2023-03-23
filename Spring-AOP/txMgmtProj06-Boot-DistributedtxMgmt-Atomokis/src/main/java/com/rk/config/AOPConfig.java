package com.rk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {
	
	@Bean(name = "aksDTxServcie")
	public UserTransactionImp createAksDTxService() {
		return new UserTransactionImp();
	}
	
	@Bean(name = "aksDTxMgmr")
	public UserTransactionManager createAKsDTxMgmr() {
		return new UserTransactionManager();
	}
	
	
	@Bean(name = "jtaTxMgmr")
	public TransactionManager createJTATxMgmr() {
		/*
		 * JtaTransactionManager jtaTxMgmr=new JtaTransactionManager();
		 * jtaTxMgmr.setUserTransaction(createAksDTxService());
		 * jtaTxMgmr.setTransactionManager(createAKsDTxMgmr()); return jtaTxMgmr;
		 */
		return new JtaTransactionManager(createAksDTxService(),createAKsDTxMgmr());
		
	}
}
