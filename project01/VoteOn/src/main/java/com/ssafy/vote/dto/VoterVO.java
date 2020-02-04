package com.ssafy.vote.dto;

public class VoterVO {
	private int code;
	private String id_num;
	private String name;
	private String areaCode;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public String getId_num() {
		return id_num;
	}


	public void setId_num(String id_num) {
		this.id_num = id_num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Override
	public String toString() {
		return "VoterVO [code=" + code + ", id_num=" + id_num + ", name=" + name + ", areaCode=" + areaCode + "]";
	}


	public VoterVO() {
	}


	public VoterVO(int code, String id_num, String name, String areaCode) {
		this.code = code;
		this.id_num = id_num;
		this.name = name;
		this.areaCode = areaCode;
	}
	
	public VoterVO(int code, String name, String areaCode) {
		this.code = code;
		this.name = name;
		this.areaCode = areaCode;
	}	
	
	public VoterVO(String name, String id_num) {
		this.name = name;
		this.id_num = id_num;
	}


}
