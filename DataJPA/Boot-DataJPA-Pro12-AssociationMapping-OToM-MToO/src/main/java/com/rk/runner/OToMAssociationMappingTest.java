package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IOToMAssociationMgmtService;

@Component
public class OToMAssociationMappingTest implements  CommandLineRunner{

	@Autowired
	private IOToMAssociationMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//service.saveDataUsingParent();
		//service.saveDataUsingChid();
		//service.loadDataUsingParent();
		//service.deleteDataUsingParentById(2);
		//service.deleteAllChildsofAParentById(2);
		service.AddNewChildtoAParentById(2);
	}

}
