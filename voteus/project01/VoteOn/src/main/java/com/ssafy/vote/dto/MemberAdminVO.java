package com.ssafy.vote.dto;

public class MemberAdminVO {
	private String ma_id;
	private String ma_name;
	private String ma_pw;
	
	public MemberAdminVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberAdminVO(String ma_id, String ma_name, String ma_pw) {
		super();
		this.ma_id = ma_id;
		this.ma_name = ma_name;
		this.ma_pw = ma_pw;
	}

	public String getMa_id() {
		return ma_id;
	}

	public void setMa_id(String ma_id) {
		this.ma_id = ma_id;
	}

	public String getMa_name() {
		return ma_name;
	}

	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}

	public String getMa_pw() {
		return ma_pw;
	}

	public void setMa_pw(String ma_pw) {
		this.ma_pw = ma_pw;
	}
}
