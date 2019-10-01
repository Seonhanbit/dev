package edu.ssafy.vo;

public class Member {
	String id;
	String pw;
	String name;
	String addr;
	public Member(String id, String pw, String name, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
	}
	public Member() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
}
