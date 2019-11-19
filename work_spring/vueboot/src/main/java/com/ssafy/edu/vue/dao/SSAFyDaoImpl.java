package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;
@Repository
public class SSAFyDaoImpl implements ISSAFYDao{
	
    private String ns="com.ssafy.edu.vue.dao.HrmMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return sqlSession.selectList(ns+"findAllEmployees");
	}
	
	@Override
	public int getEmployeesTotal() throws Exception{
		return sqlSession.selectOne(ns+"getEmployeesTotal");
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
		return sqlSession.selectList(ns+"findLikeEmployees",name);
	}

	@Override
	public void addEmployee(EmployeeDto emp) throws Exception {
		sqlSession.insert(ns+"addEmployee",emp);
	}

	@Override
	public List<DepartmentDto> findAllDepartments() throws Exception {
		return sqlSession.selectList(ns+"findAllDepartments");
	}

	@Override
	public int findAfterAdd() throws Exception{
		return sqlSession.selectOne(ns+"findAfterAdd");
	}

	@Override
	public List<EmployeeDto> findAllTitles() throws Exception {
		return sqlSession.selectList(ns+"findAllTitles");
	}

	@Override
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return sqlSession.selectOne(ns+"findEmployeeById",id);
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		 sqlSession.update(ns+"updateEmployee",emp);
		 return true;
	}

	@Override
	public boolean deleteEmployee(int id) throws Exception {
		sqlSession.delete(ns+"deleteEmployee",id);
		 return true;
	}

	@Override
	public List<DepCountDto> findAllDepCounts() throws Exception {
		return sqlSession.selectList(ns+"findAllDepCounts");
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) throws Exception {
		return sqlSession.selectList(ns+"findEmployeesByManagerId",managerId);
	}

	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) throws Exception {
		return sqlSession.selectList(ns+"findDepartmentsBydeptid",dept_id);
	}

	@Override
	public List<EmployeeDto> findDepartmentsByname(String name) throws Exception {
		return sqlSession.selectList(ns+"findDepartmentsByname",name);
	}

	@Override
	public List<DepartmentEmpDto> findAllDeptEmps() throws Exception {
		return sqlSession.selectList(ns+"findAllDeptEmps");
	}
	
}
