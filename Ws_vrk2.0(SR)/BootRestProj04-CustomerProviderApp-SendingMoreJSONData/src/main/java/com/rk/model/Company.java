package com.rk.model;

import lombok.Data;

@Data
public class Company {
	private Integer id;
	private String name;
	private String addrs;
	private String type;
	
	
	
	
	public Company(Integer id, String name, String addrs, String type) {
		
		this.id = id;
		this.name = name;
		this.addrs = addrs;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}