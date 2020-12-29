package com.ehualu.data.business.template.model;

/**
 * @author created by gouyifan on 2020/3/13
 */
public class AddrInfoResp {
	private String townCode;
	private String committeeCode;
	private String areaCode;
	
	
	public AddrInfoResp() {
		super();
	}


	public AddrInfoResp(AddrInfo addrInfo) {
		super();
		this.townCode = addrInfo.getTownCode();
		this.committeeCode = addrInfo.getCommitteeCode();
		this.areaCode = addrInfo.getAreaCode();
	}


	public String getTownCode() {
		return townCode;
	}


	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}


	public String getCommitteeCode() {
		return committeeCode;
	}


	public void setCommitteeCode(String committeeCode) {
		this.committeeCode = committeeCode;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	};
	
	
}
