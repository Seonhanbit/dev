package com.ssafy.vote.dto;

public class VoterVO {
	private int code;
	private String name;
	private String areaCode;
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
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


	public VoterVO(int code, String name, String areaCode) {
		this.code = code;
		this.name = name;
		this.areaCode = areaCode;
	}

	public VoterVO(String name, String areaCode) {
		this.name = name;
		this.areaCode = areaCode;
	}

	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


}
