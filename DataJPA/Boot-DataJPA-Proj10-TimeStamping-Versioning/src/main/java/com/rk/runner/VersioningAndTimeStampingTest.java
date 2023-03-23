package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.entity.CallerTuneInfo;
import com.rk.service.ICalllerTuneMgmtService;

@Component
public class VersioningAndTimeStampingTest implements CommandLineRunner{

	@Autowired
	private ICalllerTuneMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			CallerTuneInfo info=new CallerTuneInfo("oo antava mama","puspha");
			System.out.println("CallerTuneInfo(\"oo antava mama\",\"puspha\")");
			System.out.println(service.saveCallerTuneInfo(info));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=================================================");
		try {
			Thread.sleep(3000);
			System.out.println(service.updateTuneInfoById(1, "Natu Natu", "RRR"));
			System.out.println(service.showCallerTuneDetailsById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
