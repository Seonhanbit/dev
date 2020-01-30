package com.ssafy.vote.dto;

public class CandidateVO {
	private int code;
	private String name;
	private String num;
	private String party;
	private int votecode;
	private int pick;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotecode() {
		return votecode;
	}
	public void setVotecode(int votecode) {
		this.votecode = votecode;
	}
	public int getPick() {
		return pick;
	}
	public void setPick(int pick) {
		this.pick = pick;
	}
	@Override
	public String toString() {
		return "candidateVO [code=" + code + ", name=" + name + ", num=" + num + ", party=" + party + ", votecode="
				+ votecode + ", pick=" + pick + "]";
	}
	public CandidateVO() {
	}
	public CandidateVO(int code, String name, String num, String party, int votecode, int pick) {
		super();
		this.code = code;
		this.name = name;
		this.num = num;
		this.party = party;
		this.votecode = votecode;
		this.pick = pick;
	}
	public CandidateVO(String name, String num, String party, int votecode, int pick) {
		this.name = name;
		this.num = num;
		this.party = party;
		this.votecode = votecode;
		this.pick = pick;
	}
	
}
