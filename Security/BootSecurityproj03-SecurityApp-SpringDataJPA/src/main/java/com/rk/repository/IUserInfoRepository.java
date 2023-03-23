package com.rk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.UserInfo;

public interface IUserInfoRepository extends JpaRepository<UserInfo, Integer>{
	public Optional<UserInfo> findByUname(String uname);
}
