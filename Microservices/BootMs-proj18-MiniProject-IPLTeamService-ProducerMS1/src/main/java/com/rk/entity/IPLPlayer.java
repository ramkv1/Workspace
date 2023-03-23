package com.rk.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MS_MP_PLAYER")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class IPLPlayer {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PLAYER_ID_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer playerId;
	@Column(length = 20)
	@NonNull
	private String playername;
	@Column(length=10)
	@NonNull
	private String role;
	@NonNull
	private Integer jersyNo;
	
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "TEAM_INFO_ID",referencedColumnName = "TEAM_ID")
	private IPLTeam teamInfo;
	
	
	//to String
	@Override
	public String toString() {
		return "IPLPlayer [playerId=" + playerId + ", playername=" + playername + ", role=" + role + ", jersyNo="
				+ jersyNo + "]";
	}
	
}
