package com.rk.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Person;
import com.rk.entity.PhoneNumber;
import com.rk.repository.IPersonRepository;
import com.rk.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	@Override
	public List<Object[]> fetchDataUsingJoins() {
		return personRepo.getDataUsingJoins();
	}
	
	
	
}
