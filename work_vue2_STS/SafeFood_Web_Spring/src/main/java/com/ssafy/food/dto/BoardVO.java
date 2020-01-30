package com.ssafy.food.dto;

public class BoardVO {
	private int num;
	private String id;
	private String title;
	private String content;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BoardVO(int num, String id, String title, String content) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public BoardVO(int num, String title, String content) {
		this.num = num;
		this.title = title;
		this.content = content;
	}
	public BoardVO(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public BoardVO() {
	}
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + "]";
	}
}
