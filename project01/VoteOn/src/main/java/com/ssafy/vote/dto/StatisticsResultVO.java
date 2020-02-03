package com.ssafy.vote.dto;

public class StatisticsResultVO {
	private String hour;
	private String cnt;
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public StatisticsResultVO() {
	}
	public StatisticsResultVO(String hour, String cnt) {
		super();
		this.hour = hour;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "StatisticsResultVO [hour=" + hour + ", cnt=" + cnt + "]";
	}
	
}
