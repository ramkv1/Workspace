package com.rk.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.client.ITeamServiceConsumerClient;
import com.rk.entity.IPLPlayer;
import com.rk.entity.IPLTeam;
import com.rk.service.IPlayerMgmtService;

@RestController
@RequestMapping("/player/api")
public class IPLPlayerOperationsController {
	
	@Autowired
	private IPlayerMgmtService playerMgmtService;
	@Autowired
	private ITeamServiceConsumerClient client;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		//get Team Details from Producer MS using FeignClient comp
		IPLTeam team=client.getTeamById(player.getTeamInfo().getTeamId()).getBody();
		//set Team Object to current player Object
		player.setTeamInfo(team);
		//use service
		String msg=playerMgmtService.saveTeam(player);		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLPlayer>> fetchAllPlayers(){
		//use service
		Iterable<IPLPlayer> list=playerMgmtService.showAllPlayers();
		return new ResponseEntity<Iterable<IPLPlayer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> findPlayerById(@PathVariable(name = "id") Integer id){
		//use service
		IPLPlayer player=playerMgmtService.showPlayerById(id);
		return new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
	}
}
