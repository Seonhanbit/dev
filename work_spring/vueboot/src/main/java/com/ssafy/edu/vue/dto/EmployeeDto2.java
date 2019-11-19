package com.ssafy.edu.vue.dto;

import java.io.Serializable;
//com.ssafy.edu.vue.dto.EmployeeDto
public class EmployeeDto2 implements Serializable {
	
	private String deptname;

	public EmployeeDto2() {}
	public void setDeptname(int id, String name, String mailid) {
		this.deptname = ""+id;
		this.deptname+= "|" +name;
		this.deptname+= "|" +mailid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
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