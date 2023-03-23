package com.rk.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rk.entity.UserInfo;

public interface IUserInfoService extends UserDetailsService{
	public String register(UserInfo user);
}
