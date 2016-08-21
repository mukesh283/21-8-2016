package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;





public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee findById(int id);
	public void updateEmployee(Employee emp); 
	public void deleteEmployee(int employeeId);
	public Employee findByKinId(String employeeid);
	public List<Department> getAllDepartments();
	public List<Project> getAllProjects();
	public List<Role> getAllRoles();
	Role findRole(String rolId);
	Project findProject(String projId);
	Department findDepartment(String depId);
	public void includeDepartment();
	public void includeProject();
	public void includeRole();
}
