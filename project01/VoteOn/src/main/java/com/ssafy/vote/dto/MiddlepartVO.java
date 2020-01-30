package com.ssafy.vote.dto;

public class MiddlepartVO {
	private String code;
	private String name;
	private String mainpart;
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
	public String getMainpart() {
		return mainpart;
	}
	public void setMainpart(String mainpart) {
		this.mainpart = mainpart;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public MiddlepartVO() {
	}
	public MiddlepartVO(String code, String name, String mainpart, String areaCode) {
		super();
		this.code = code;
		this.name = name;
		this.mainpart = mainpart;
		this.areaCode = areaCode;
	}
	@Override
	public String toString() {
		return "MiddlepartVO [code=" + code + ", name=" + name + ", mainpart=" + mainpart + ", areaCode=" + areaCode
				+ "]";
	}
}
