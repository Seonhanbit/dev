package edu.ssafy.dto;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int count;
	
	public Board() {}
	
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
		StringBuilder builder = new StringBuilder();
		builder.append("Board [seq=").append(seq).append(", title=").append(title).append(", writer=").append(writer)
				.append(", context=").append(content).append(", regDate=").append(regDate).append(", count=")
				.append(count).append("]");
		return builder.toString();
	}
	
}
