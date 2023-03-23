package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLPlayer;
import com.rk.entity.IPLTeam;
import com.rk.repository.IIPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service("teamService")
@Slf4j
public class PlayerMgmtServiceImpl implements IPlayerMgmtService{
	
	@Autowired
	private IIPLPlayerRepository playerRepo;

	@Override
	public String saveTeam(IPLPlayer player) {
		log.info("PlayerMgmtServiceImpl.saveTeam()");
		int idval=playerRepo.save(player).getPlayerId();
		return "player is saved with idValue"+idval;
	}

	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		log.info("PlayerMgmtServiceImpl.showAllPlayers()");
		return playerRepo.findAll();
	}

	@Override
	public IPLPlayer showPlayerById(Integer id) {
		log.info("PlayerMgmtServiceImpl.showPlayerById()");
		return playerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Player Id"));
	}

}
