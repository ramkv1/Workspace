package com.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer>{

}
