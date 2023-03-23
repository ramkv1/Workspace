package com.rk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("comp2")
@ConfigurationProperties(prefix = "org.info")
public class Company2 {
	private String name;
	private String location;
	@Value("{$org.info.Csize}")
	private String type;
	private Integer size;
	private Integer contact;
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public void setContact(Integer contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Company2 [name=" + name + ", location=" + location + ", type=" + type + ", size=" + size + ", contact="
				+ contact + "]";
	}
	
	
	
}
