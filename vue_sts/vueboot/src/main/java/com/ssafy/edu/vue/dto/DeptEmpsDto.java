package com.ssafy.edu.vue.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeptEmpsDto implements Serializable {

	private String deptname;
	
	private List<EmployeeDto2> children=new ArrayList<>();
	
	public DeptEmpsDto() {
		
	}
	public DeptEmpsDto(int deptid, String dname) {
		super();
		this.deptname = deptid+"("+dname+")";
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public List<EmployeeDto2> getChildren() {
		return children;
	}
	public void setChildren(List<EmployeeDto2> children) {
		this.children = children;
	}
	
	
	
	
}
