package com.rk.dao;

public interface IBankDAO {
	public int withdraw(int accno,double amount);
	public int deposite(int accno,double amount);
}
