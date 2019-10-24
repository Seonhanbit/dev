package edu.ssafy.util;

public class BoardDto {
	private String no;
	private String title;
	private String content;
	public BoardDto(String no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
	public BoardDto() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
