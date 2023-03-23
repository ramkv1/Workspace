package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.MarriageSeeker;
import com.rk.repository.IMarriageSeekerRepository;

@Service("marriageService")
public class MarriageSeekerMgmtServiceImpl implements IMarriagerSeekerMgmtService {

	@Autowired
	private IMarriageSeekerRepository repository;
	
	
	@Override
	public String saveMarriageSeeker(MarriageSeeker seeker) {
		int idVal=repository.save(seeker).getMsid();
		return "Marriage Seeker is registered with the id value::"+idVal;
	}


	@Override
	public MarriageSeeker findMarriageSeekerById(int id) {
		return repository.findById(id).orElseThrow(()->new IllegalArgumentException(""));
	}

}
