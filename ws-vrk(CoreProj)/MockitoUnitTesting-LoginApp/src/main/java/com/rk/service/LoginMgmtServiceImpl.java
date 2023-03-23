package com.rk.service;

import com.rk.dao.ILoginDAO;

public class LoginMgmtServiceImpl implements ILoginMgmtService {
	
	private ILoginDAO loginDAO;
	
	public LoginMgmtServiceImpl(ILoginDAO loginDAO) {
		this.loginDAO=loginDAO;
	}
	
	@Override
	public Boolean login(String username, String password) {
		if(username.equals("")|| password.equals("")) 
			throw new IllegalArgumentException("Empty credentials");
			//use LoginDao
			int Count=loginDAO.authenticate(username, password);
			System.out.println("service::login::count::"+Count);
			if(Count==0) 
				return false;
			
			else 
				return true;	
	}
}
