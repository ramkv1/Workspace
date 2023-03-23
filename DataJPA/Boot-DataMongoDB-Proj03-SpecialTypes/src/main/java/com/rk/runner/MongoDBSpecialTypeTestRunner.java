package com.rk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.service.IPlayerMgmtService;

@Component
public class MongoDBSpecialTypeTestRunner implements CommandLineRunner{

	@Autowired
	private IPlayerMgmtService Service;
	
	@Override
	public void run(String... args) throws Exception {
		/*		PlayerInfo info=new PlayerInfo();
				info.setPid(new Random().nextInt(10000));
				info.setPname("Rohit");
				info.setNickName(new String[] {"raj","King","Mahraj"});
				info.setFriends(List.of("Srinivas","Mahesh","Suresh"));
				info.setPhoneNumber(Set.of(99999999L,54874879797L,545878487966L));
				Properties props=new Properties();
				props.put("Bat", "SG");props.put("Batting Pads", "SS");
				props.put("ball", "KookBura");
				info.setKitInfo(props);
				info.setIdDetails(Map.of("aadhar",54647489l,"VoterId",67848575L));
				
				try {
					System.out.println(Service.registerPlayer(info));
				} catch (Exception e) {
					e.printStackTrace();
				}

				*/
		
		try {
			Service.ShowAllPlayersInfo().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
