package com.ssafy.vote.dto;

public class StatisticsVO {
	private int s_code;
	private int candi_code;
	private String s_date;
	public int getS_code() {
		return s_code;
	}
	public void setS_code(int s_code) {
		this.s_code = s_code;
	}
	public int getCandi_code() {
		return candi_code;
	}
	public void setCandi_code(int candi_code) {
		this.candi_code = candi_code;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public StatisticsVO() {
	}
	public StatisticsVO(int s_code, int candi_code, String s_date) {
		super();
		this.s_code = s_code;
		this.candi_code = candi_code;
		this.s_date = s_date;
	}
	public StatisticsVO(int candi_code, String s_date) {
		this.candi_code = candi_code;
		this.s_date = s_date;
	}
	@Override
	public String toString() {
		return "StatisticsVO [s_code=" + s_code + ", candi_code=" + candi_code + ", s_date=" + s_date + "]";
	}
	
}
