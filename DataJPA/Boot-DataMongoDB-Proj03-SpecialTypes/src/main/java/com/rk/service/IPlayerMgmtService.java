package com.rk.service;

import java.util.List;

import com.rk.document.PlayerInfo;

public interface IPlayerMgmtService {
	public String registerPlayer(PlayerInfo playerInfo);
	public List<PlayerInfo> ShowAllPlayersInfo();
}
