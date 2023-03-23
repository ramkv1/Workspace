package com.rk.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("cust")
@ConfigurationProperties(prefix = "cust.info")
public class CustomerInfo {
	private Integer cno;
	private String cname;
	private String cadd;
	private Double billAmt;
	//generate setters
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	//To String
	
	@Override
	public String toString() {
		return "CustomerInfo [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
	}
	

}
