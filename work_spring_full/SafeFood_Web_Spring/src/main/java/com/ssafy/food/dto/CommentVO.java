package com.ssafy.food.dto;

public class CommentVO {
	private int num;
	private String qnanum;
	private String content;
	private String id;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getQnanum() {
		return qnanum;
	}
	public void setQnanum(String qnanum) {
		this.qnanum = qnanum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CommentVO() {
	}
	public CommentVO(int num, String qnanum, String content, String id) {
		super();
		this.num = num;
		this.qnanum = qnanum;
		this.content = content;
		this.id = id;
	}
	public CommentVO(int num, String content, String id) {
		this.num = num;
		this.content = content;
		this.id = id;
	}
	@Override
	public String toString() {
		return "CommentVO [num=" + num + ", qnanum=" + qnanum + ", content=" + content + ", id=" + id + "]";
	}
	
}
