package com.rk.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rk.entity.UserInfo;
import com.rk.repository.IUserInfoRepository;

@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService{

	@Autowired
	private IUserInfoRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//get Model class Object 
		Optional<UserInfo> opt=userRepo.findByUname(username);
		if(opt.isEmpty())
			throw new IllegalArgumentException("Invalid Inputs");
		
		UserInfo info=opt.get();
		//Get Roles from model class Object
		Set<String> roles=info.getRoles();
		//convert Set<String> roles to set<SGA> Object
		Set<GrantedAuthority> sgaRoles=new HashSet();
		for(String role:roles) {
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
			sgaRoles.add(authority);
		}
		//convert Model class Object into User class
		User user=new org.springframework.security.core.userdetails.User(info.getUname(), info.getPwd(), sgaRoles);
		return user;
	}

	@Override
	public String register(UserInfo user) {
		userRepo.save(user);
		return "user Register";
	}

}
