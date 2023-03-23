package com.rk.service;

import com.rk.entity.IPLPlayer;
import com.rk.entity.IPLTeam;

public interface IPlayerMgmtService {
	public String saveTeam(IPLPlayer player);
	public Iterable<IPLPlayer> showAllPlayers();
	public IPLPlayer showPlayerById(Integer id);
}
