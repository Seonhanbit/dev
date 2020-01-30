package com.ssafy.vote.dto;

public class MainpartVO {
	private String code;
	private String name;
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
	public MainpartVO(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public MainpartVO() {
	}
	@Override
	public String toString() {
		return "MainpartVO [code=" + code + ", name=" + name + "]";
	}

}
