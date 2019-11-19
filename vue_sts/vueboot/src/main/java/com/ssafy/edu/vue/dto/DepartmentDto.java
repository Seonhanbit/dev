package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class DepartmentDto implements Serializable {
	private int dept_id;
	private String name;
	private int region_id;
	public DepartmentDto() {
	}
	public DepartmentDto(int dept_id, String name, int region_id) {
		super();
		this.dept_id = dept_id;
		this.name = name;
		this.region_id = region_id;
	}
	@Override
	public String toString() {
		return "DepartmentDto [dept_id=" + dept_id + ", name=" + name + ", region_id=" + region_id + "]";
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	
}
