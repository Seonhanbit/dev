package com.ssafy.vote.dto;

public class VotetfVO {
	private int votercode;
	private int votecode;
	public int getVotercode() {
		return votercode;
	}
	public void setVotercode(int votercode) {
		this.votercode = votercode;
	}
	public int getVotecode() {
		return votecode;
	}
	public void setVotecode(int votecode) {
		this.votecode = votecode;
	}

	public VotetfVO(int votercode, int votecode) {
		super();
		this.votercode = votercode;
		this.votecode = votecode;
	}
	public VotetfVO() {
	}
	@Override
	public String toString() {
		return "VoteTFVO [votercode=" + votercode + ", votecode=" + votecode + "]";
	}
	
	
}
