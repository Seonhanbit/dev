package com.ssafy.vote.dto;

public class VoteVO {
	private int code;
	private String name;
	private String middlepart;
	private String start;
	private String end;
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
	public String getMiddlepart() {
		return middlepart;
	}
	public void setMiddlepart(String middlepart) {
		this.middlepart = middlepart;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public VoteVO() {
		
	}
	public VoteVO(int code, String name, String middlepart, String start, String end) {
		super();
		this.code = code;
		this.name = name;
		this.middlepart = middlepart;
		this.start = start;
		this.end = end;
	}
	public VoteVO(String name, String middlepart, String start, String end) {
		this.name = name;
		this.middlepart = middlepart;
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "VoteVO [code=" + code + ", name=" + name + ", middlepart=" + middlepart + ", start=" + start + ", end="
				+ end + "]";
	}
	
}
