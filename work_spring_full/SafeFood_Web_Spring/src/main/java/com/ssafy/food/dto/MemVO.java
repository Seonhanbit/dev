package com.ssafy.food.dto;

public class MemVO {
	private String id;
    private String pw;
    private String name;
    private String addr;
    private String email;
    private String tel;
    private String alinfo;
    private String pick;
    
    
    public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public MemVO() {
        super();
    }
    public MemVO(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.addr = addr;
        this.email = email;
        this.tel = tel;
        this.alinfo = alinfo;
    }
    
    public MemVO(String id, String pw, String name, String addr, String email, String tel, String alinfo, String pick) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.tel = tel;
		this.alinfo = alinfo;
		this.pick = pick;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAlinfo() {
        return alinfo;
    }
    public void setAlinfo(String alinfo) {
        this.alinfo = alinfo;
    }
    @Override
    public String toString() {
        return "MemVO [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", email=" + email + ", tel="
                + tel + ", alinfo=" + alinfo + "]";
    }
    
}
