package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.ISSAFYDao;
import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
	private ISSAFYDao employeeDao;

    @Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return employeeDao.findAllEmployees();
	}
    
    @Override
	@Transactional(readOnly=true)
	public int getEmployeesTotal() throws Exception {
		return employeeDao.getEmployeesTotal();
	}

    @Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
    	return employeeDao.findLikeEmployees(name);
	}

	@Override
	@Transactional
	public int addEmployee(EmployeeDto emp) throws Exception {
		//나중에 auto로 바꾸기
		emp.setId(employeeDao.findAfterAdd()+1);
		employeeDao.addEmployee(emp);
		return employeeDao.findAfterAdd();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentDto> findAllDepartments() throws Exception {
		return employeeDao.findAllDepartments();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllTitles() throws Exception {
		return employeeDao.findAllTitles();
	}

	@Override
	@Transactional(readOnly=true)
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return employeeDao.findEmployeeById(id);
	}

	@Override
	@Transactional
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) throws Exception {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepCountDto> findAllDepCounts() throws Exception {
		return employeeDao.findAllDepCounts();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) throws Exception {
		return employeeDao.findEmployeesByManagerId(managerId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) throws Exception {
		return employeeDao.findDepartmentsBydeptid(dept_id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findDepartmentsByname(String name) throws Exception {
		return employeeDao.findDepartmentsByname(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentEmpDto> findAllDeptEmps() throws Exception {
		return employeeDao.findAllDeptEmps();
	}
	
}
