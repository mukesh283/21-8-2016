package com.flp.ems.service;

import java.util.List;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flp.ems.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private  EmployeeDao employeeDao;

	@Transactional
	public void saveEmployee(Employee employee) {
		
		employeeDao.saveEmployee(employee);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public void deleteEmployee(int employeeId) {
		
		employeeDao.deleteEmployee(employeeId);
	}
	@Transactional
	public Employee findById(int id){
		return employeeDao.findById(id);
	}
	@Transactional
	public void updateEmployee(Employee emp){
		employeeDao.updateEmployee(emp);
	}

	@Transactional
	public Employee findByKinId(String employeeid) {
		Employee emp=employeeDao.findByKinId(employeeid);
		return emp;
	}
	
	@Transactional
	public List<Department> getAllDepartments() {
		
		return employeeDao.getAllDepartments();
	}

	@Transactional
	public List<Project> getAllProjects() {
		
		return employeeDao.getAllProjects();
	}

	@Transactional
	public List<Role> getAllRoles() {
		
		return employeeDao.getAllRoles();
	}

	@Transactional
	public Role findRole(String rolId) {
		Role rol=employeeDao.findRole(rolId);
		return rol;
	}

	@Transactional
	public Project findProject(String projId) {
		Project proj=employeeDao.findProject(projId);
		return proj;
	}

	@Transactional
	public Department findDepartment(String depId) {
		Department dept=employeeDao.findDepartment(depId);
		return dept;
	}
	
}
