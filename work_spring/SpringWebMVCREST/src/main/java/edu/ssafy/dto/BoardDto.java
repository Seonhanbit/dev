package edu.ssafy.dto;

public class BoardDto {
	private String num;
	private String title;
	private String content;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
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
	public BoardDto(String num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}
	public BoardDto() {}
	
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", title=" + title + ", content=" + content + "]";
	}	
}
