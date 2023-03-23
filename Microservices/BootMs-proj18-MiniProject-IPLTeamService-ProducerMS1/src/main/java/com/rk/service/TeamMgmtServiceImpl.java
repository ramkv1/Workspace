package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLTeam;
import com.rk.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("teamService")
@Slf4j
public class TeamMgmtServiceImpl implements ITeamMgmtService{
	
	@Autowired
	private IIPLTeamRepository teamRepo;

	@Override
	public String saveTeam(IPLTeam team) {
		log.info("TeamMgmtServiceImpl.saveTeam()::method-Saving the Team");
		return "Team and player are saved with id value:"+teamRepo.save(team).getTeamId();
	}

	@Override
	public Iterable<IPLTeam> showAllTeams() {
		log.info("TeamMgmtServiceImpl.showAllTeams() method");
		return teamRepo.findAll();
	}

	@Override
	public IPLTeam showTeamById(Integer id) {
		log.info("TeamMgmtServiceImpl.showTeamById(Integer id)method ");
		return teamRepo.getOne(id);
	}

}
