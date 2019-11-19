package com.ssafy.edu.vue.dto;

public class DepCountDto {
	private int count;
	private int dept_id;
	private String name="NOTYET";
	public DepCountDto() {
	}
	public DepCountDto(int count, int dept_id, String name) {
		super();
		this.count = count;
		this.dept_id = dept_id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "DepCountDto [count=" + count + ", dept_id=" + dept_id + ", name=" + name + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	
}
