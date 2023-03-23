package com.rk.service;

import com.rk.entity.MarriageSeeker;

public interface IMarriagerSeekerMgmtService {
	public String saveMarriageSeeker(MarriageSeeker seeker);
	public MarriageSeeker findMarriageSeekerById(int id);
}
