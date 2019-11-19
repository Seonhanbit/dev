package com.ssafy.edu.vue.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

public interface ISSAFYDao {
	public List<EmployeeDto> findAllEmployees() throws Exception;
	
	public EmployeeDto findEmployeeById(int id) throws Exception;
	public  int getEmployeesTotal()throws Exception;
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception;
	public void addEmployee(EmployeeDto emp) throws Exception;
	public List<DepartmentDto> findAllDepartments() throws Exception;
	public int findAfterAdd() throws Exception;
	public List<EmployeeDto> findAllTitles() throws Exception;
	public boolean updateEmployee(EmployeeDto emp) throws Exception;
	public boolean deleteEmployee(int id) throws Exception;
	

	
	public List<DepCountDto> findAllDepCounts()throws Exception;
	public List<EmployeeDto>  findEmployeesByManagerId(int managerId)throws Exception;
	
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id)throws Exception;
	public List<EmployeeDto> findDepartmentsByname(String name)throws Exception;

	public List<DepartmentEmpDto> findAllDeptEmps()throws Exception;
	
}
