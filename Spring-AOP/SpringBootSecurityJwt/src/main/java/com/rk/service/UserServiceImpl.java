package com.rk.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rk.entity.User;
import com.rk.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public Integer saveUser(User user) {
		
		//Encode password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return repository.save(user).getId();
		
		
	}
	//get user by username
	public Optional<User> findByUsername(String username){
		return repository.findByUsername(username);
	}
	
	//-___----------------
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<User> opt=findByUsername(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("User not exits");
		//read user from Db
		User user=opt.get();
		
		return new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(), 
				user.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role))
				.collect(Collectors.toList())
				);
	}

}
