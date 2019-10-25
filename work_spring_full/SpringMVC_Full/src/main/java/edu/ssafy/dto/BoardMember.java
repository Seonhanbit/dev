package edu.ssafy.dto;

import java.sql.Date;

public class BoardMember {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int count;
	private Member member;// = new Member();
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
	public BoardMember() {
		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String context) {
		this.content = context;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoardMember [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", count=" + count + ", member=" + member.toString() + "]";
	}

	
	
}
