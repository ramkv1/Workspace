package com.rk.model;

public class Actor {
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private Double remuneration;
	
	//Getters and Setters
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorAddrs() {
		return actorAddrs;
	}
	public void setActorAddrs(String actorAddrs) {
		this.actorAddrs = actorAddrs;
	}
	public Double getRemuneration() {
		return remuneration;
	}
	public void setRemuneration(Double remuneration) {
		this.remuneration = remuneration;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs
				+ ", remuneration=" + remuneration + "]";
	}
	
	
}
