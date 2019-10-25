package edu.ssafy.dto;

import java.io.Serializable;

public class RestReply implements Serializable{
	String reQMsg;
	String reSMsg;
	String code;
	public RestReply(String reSMsg, String code) {
		super();
		this.reSMsg = reSMsg;
		this.code = code;
	}
	
	public RestReply(String reQMsg, String reSMsg, String code) {
		super();
		this.reQMsg = reQMsg;
		this.reSMsg = reSMsg;
		this.code = code;
	}

	public RestReply() {
		super();
	}
	public String getReQMsg() {
		return reQMsg;
	}
	public void setReQMsg(String reQMsg) {
		this.reQMsg = reQMsg;
	}
	public String getReSMsg() {
		return reSMsg;
	}
	public void setReSMsg(String reSMsg) {
		this.reSMsg = reSMsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "RestReply [reQMsg=" + reQMsg + ", reSMsg=" + reSMsg + ", code=" + code + "]";
	}
}
