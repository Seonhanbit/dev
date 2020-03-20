package com.ssafy.vote.dto;

public class PartyVO {
	private String p_code;
	private String p_name;
	public String getp_code() {
		return p_code;
	}
	public void setp_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public PartyVO(String p_code, String p_name) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
	}
	public PartyVO() {
	}
	@Override
	public String toString() {
		return "PartyVO [p_code=" + p_code + ", p_name=" + p_name + "]";
	}
	
}
