package com.flp.ems.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		
	}
	@Override
	public Employee findById(int id){
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	    return emp; 
	}
	@Override
	public void updateEmployee(Employee emp){
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		 
	}
	@Override
	public Employee findByKinId(String employeeid) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeid);
		return emp;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public List<Department> getAllDepartments() {
		//includeDepartment();
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

	@Override
	public List<Project> getAllProjects() {
		//includeProject();
		return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public List<Role> getAllRoles() {
		//includeRole();
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}
	
	@Override
	public Department findDepartment(String depId) {
		int deptId=Integer.parseInt(depId);
		Department dept=(Department)sessionFactory.getCurrentSession().get(Department.class, deptId);
		return dept;
	}
	@Override
	public Project findProject(String projId) {
		int projectId=Integer.parseInt(projId);
		Project proj=(Project)sessionFactory.getCurrentSession().get(Project.class, projectId);
		return proj;
	}
	@Override
	public Role findRole(String rolId) {
		int roleId=Integer.parseInt(rolId);
		 Role rol=(Role)sessionFactory.getCurrentSession().get(Role.class, roleId);
		return rol;
	}
	
	@Override
	public void includeDepartment(){
		Department d1=new Department(50,"HR","Managerial");
		Department d2=new Department(51,"FS","Financial Service");
		Department d3=new Department(52,"NFS","Non-Financial Service");
		//Department d4=new Department(53,"ADM","Developement");
		sessionFactory.getCurrentSession().save(d1);
		sessionFactory.getCurrentSession().save(d2);
		sessionFactory.getCurrentSession().save(d3);
		//sessionFactory.getCurrentSession().save(d4);
		
	}
	
	@Override
	public void includeProject(){
		/*Department d1=new Department(50,"HR","Developement");
		Department d2=new Department(52,"FS","Developement");
		Department d3=new Department(53,"NFS","Developement");
		Department d4=new Department(54,"ADM","Developement");*/
		Project p1=new Project(500,"MORGAN","Morgan Stanley",50);
		Project p2=new Project(501,"MICROSOFT","Microsoft",51);
		Project p3=new Project(502,"SAP","S.A.P",52);
		Project p4=new Project(503,"ORACLE","Oracle",53);
		//Project p5=new Project(504,"AMAZON","Amazon",54);
		sessionFactory.getCurrentSession().save(p1);
		sessionFactory.getCurrentSession().save(p2);
		sessionFactory.getCurrentSession().save(p3);
		sessionFactory.getCurrentSession().save(p4);
		//sessionFactory.getCurrentSession().save(p5);
	}
	
	@Override
	public void includeRole(){
		Role r1=new Role(2000,"Software Engg","Develop");
		Role r2=new Role(2001,"Consultant","Test");
		Role r3=new Role(2002,"Manager","Maintainence");
		Role r4=new Role(2003,"HR","Cloud");
		sessionFactory.getCurrentSession().save(r1);
		sessionFactory.getCurrentSession().save(r2);
		sessionFactory.getCurrentSession().save(r3);
		sessionFactory.getCurrentSession().save(r4);
			
	}
	
	
}
