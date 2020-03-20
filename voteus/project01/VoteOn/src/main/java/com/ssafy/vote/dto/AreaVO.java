package com.ssafy.vote.dto;

public class AreaVO {
	private String areaCode;
	private String name;
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AreaVO [areaCode=" + areaCode + ", name=" + name + "]";
	}
	public AreaVO(String areaCode, String name) {
		super();
		this.areaCode = areaCode;
		this.name = name;
	}
	public AreaVO() {
	}
	
}
