package com.rk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.CallerTuneInfo;
import com.rk.repository.ICallerTuneInfoRepository;

@Service("callerTuneService")
public class CallerTuneServiceImpl implements ICalllerTuneMgmtService{

	@Autowired
	private ICallerTuneInfoRepository callerTuneRepo;
	
	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer idVal=callerTuneRepo.save(info).getTuneId();
		return "CallerTune is Saved with the id Value::"+idVal;
	}

	@Override
	public String updateTuneInfoById(Integer id,String tuneName,String movieName) {
		Optional<CallerTuneInfo> optional=callerTuneRepo.findById(id);
		if(optional.isPresent()) {
			CallerTuneInfo info=optional.get();
			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallerTuneInfo tune=callerTuneRepo.save(info);
			return "Object is Updated for:::::"+tune.getUpdatedCount()+"::::times..lastly modified on::::"+tune.getLastlyUpdatedOn()+"::::created on::::"+tune.getServiceOptedOn();
		}
		else {
			return "CallerTuneService is not found";
		}
	}

	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		return callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("caller tune not found"));
	}

}
