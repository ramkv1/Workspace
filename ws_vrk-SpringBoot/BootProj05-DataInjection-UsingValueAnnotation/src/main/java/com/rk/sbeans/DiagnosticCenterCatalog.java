package com.rk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
@Data
public class DiagnosticCenterCatalog {
	@Value("${dc.xrayRate}")
	private Double xrayPrice;
	@Value("${dc.ctscanRate}")
	private Double ctscanPrice;
	@Value("${dc.mriScanRate}")
	private Double MRIScanPrice;
	@Value("${dc.ecgRate}")
	private Double ecgPrice;
	
	//setters and getters
	public Double getXrayPrice() {
		return xrayPrice;
	}
	public void setXrayPrice(Double xrayPrice) {
		this.xrayPrice = xrayPrice;
	}
	public Double getCtscanPrice() {
		return ctscanPrice;
	}
	public void setCtscanPrice(Double ctscanPrice) {
		this.ctscanPrice = ctscanPrice;
	}
	public Double getMRIScanPrice() {
		return MRIScanPrice;
	}
	public void setMRIScanPrice(Double mRIScanPrice) {
		MRIScanPrice = mRIScanPrice;
	}
	public Double getEcgPrice() {
		return ecgPrice;
	}
	public void setEcgPrice(Double ecgPrice) {
		this.ecgPrice = ecgPrice;
	}
	
}
