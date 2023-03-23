package com.rk.service;

import com.rk.entity.CallerTuneInfo;

public interface ICalllerTuneMgmtService {
	public String saveCallerTuneInfo(CallerTuneInfo info);
	public String updateTuneInfoById(Integer id,String tuneName,String movieName);
	public CallerTuneInfo showCallerTuneDetailsById(Integer id);
}
