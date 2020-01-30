package com.ssafy.food.dto;

public class QnaVO {
	private int num;
	private String title;
	private String content;
	private String id;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public QnaVO() {}
	public QnaVO(int num, String title, String content, String id) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
	}
	public QnaVO(String title, String content, String id) {
		this.title = title;
		this.content = content;
		this.id = id;
	}
	@Override
	public String toString() {
		return "QnaVO [num=" + num + ", title=" + title + ", content=" + content + ", id=" + id + "]";
	}
	
}
