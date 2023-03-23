package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.document.PlayerInfo;
import com.rk.repository.PlayerInfoRepository;

@Service
public class PlayerMgmtServiceImpl implements IPlayerMgmtService{
	
	@Autowired
	private PlayerInfoRepository Playerepo;

	@Override
	public String registerPlayer(PlayerInfo player) {
		int idval=Playerepo.insert(player).getPid();
		return "Player is Saved with IdVal::"+idval;
	}

	@Override
	public List<PlayerInfo> ShowAllPlayersInfo() {
		return Playerepo.findAll();
	}
}
