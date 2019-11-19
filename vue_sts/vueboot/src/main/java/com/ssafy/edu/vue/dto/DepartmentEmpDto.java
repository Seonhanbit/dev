package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class DepartmentEmpDto implements Serializable {
	private int deptid;
	private String dname;
	private int eid;
	private String ename;
	private String emailid;
	public DepartmentEmpDto() {
		
	}
	public DepartmentEmpDto(int deptid, String dname, int eid, String ename, String emailid) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.eid = eid;
		this.ename = ename;
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "DepartmentEmpDto [deptid=" + deptid + ", dname=" + dname + ", eid=" + eid + ", ename=" + ename
				+ ", emailid=" + emailid + "]";
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
}
