package com.rk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("pInfo")
@Data
public class PatientInfo {
	@Value("10001")
	private Integer pid;
	@Value("${pi.name}")
	private String pname;
	@Value("${pi.mobileNo}")
	private Long mobileNo;
	@Value("${pi.addrs}")
	private String paddrs;
	@Value("#{dcc.xrayPrice + dcc.ctscanPrice+dcc.ecgPrice}")
	private Double billamount;
	@Value("#{dcc.ecgPrice<=0}")//SEPL
	private Boolean ecgFree;
	@Value("${os.name}")
	private String osName;
	
	@Value("${path}")
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPaddrs() {
		return paddrs;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}
	public Double getBillamount() {
		return billamount;
	}
	public void setBillamount(Double billamount) {
		this.billamount = billamount;
	}
	public Boolean getEcgFree() {
		return ecgFree;
	}
	public void setEcgFree(Boolean ecgFree) {
		this.ecgFree = ecgFree;
	}
	/*
	 * @Override public String toString() { return "PatientInfo [pid=" + pid +
	 * ", pname=" + pname + ", mobileNo=" + mobileNo + ", paddrs=" + paddrs +
	 * ", billamount=" + billamount + ", osName=" + osName + ", path=" + path + "]";
	 * }
	 */
	@Override
	public String toString() {
		return "PatientInfo [pid=" + pid + ", pname=" + pname + ", mobileNo=" + mobileNo + ", paddrs=" + paddrs
				+ ", billamount=" + billamount + ", ecgFree=" + ecgFree + ", osName=" + osName + ", path=" + path + "]";
	}
	
	
	
	

}
