package com.ssafy.vote.dto;

public class VoterVO {
	private String code;
	private String name;
	private String areaCode;

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public VoterVO() {
	}


	public VoterVO(String code, String name, String areaCode) {
		this.code = code;
		this.name = name;
		this.areaCode = areaCode;
	}
	
	public VoterVO(String code, String name) {
		this.code = code;
		this.name = name;
	}	

	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


}
