package com.ssafy.edu.vue.dto;

import java.io.Serializable;
//com.ssafy.edu.vue.dto.EmployeeDto
public class EmployeeDto implements Serializable {
	private int id;
	private String name;
	private String mailid;
	private String start_date;
	private int manager_id;
	private String title;
	private int dept_id;
	private double salary;
	private double commission_pct=0.0;
	//부서이름 조인 용
	private String dept_name; 
	//name에 버그
	private String cname;
	
	public String getCname() {
		this.cname=name;
		return cname;
	}
	public void setCname(String cname) {
		this.name = cname;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public EmployeeDto() {}
	public EmployeeDto(int id, String name, String mailid, String start_date, int manager_id, String title, int dept_id,
			double salary, double commission_pct) {
		super();
		this.id = id;
		this.name = name;
		this.mailid = mailid;
		this.start_date = start_date;
		this.manager_id = manager_id;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
	}
	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", mailid=" + mailid + ", start_date=" + start_date
				+ ", manager_id=" + manager_id + ", title=" + title + ", dept_id=" + dept_id + ", salary=" + salary
				+ ", commission_pct=" + commission_pct + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}
	
	
	
	
	
}
/*
id                         DECIMAL(7) NOT NULL,
name                  VARCHAR(25) NOT NULL,
mailid                     VARCHAR(8),
start_date                 DATE,
manager_id                 DECIMAL(7),
title                      VARCHAR(25),
dept_id                    DECIMAL(7),
salary                     DECIMAL(11, 2),
commission_pct             DECIMAL(4, 2)
*/