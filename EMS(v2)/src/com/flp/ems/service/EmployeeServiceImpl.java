package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.view.UserInteraction;
import com.flp.ems.view.UserInteraction.*;

public class EmployeeServiceImpl implements IEmployeeService {
	
	static HashSet<String> hsforkinid=new HashSet<String>();
	static HashSet<String> hsforEmailid=new HashSet<String>();
	public void AddEmployee(HashMap hm)
	{
		EmployeeDaoImplForList Edao=new EmployeeDaoImplForList();
		Employee e=new Employee();
		Role r=new Role();
		Department d=new Department();
		Project p=new Project();
		UserInteraction ui=new UserInteraction();
		
		String name[]=new String[10];
		long num;
		name[0]=(String) hm.get(1);//employee name
		name[1]=(String) hm.get(2);//employee address
		name[2]=(String) hm.get(3);//employee email
		num= (long) hm.get(4);//employee phone
		name[3]=(String) hm.get(5);//employee dob
		name[4]=(String) hm.get(6);//employee doj
		name[5]=(String) hm.get(7);//department name
		name[6]=(String) hm.get(8);//department Description
		name[7]=(String) hm.get(9);//project name
		name[8]=(String) hm.get(10);//role name
		name[9]=(String) hm.get(11);//kinid set
		int num1=(int)hm.get(12);
		int num2=(int)hm.get(13);
		int num3=(int)hm.get(14);
		int len = hsforkinid.size();
		int len2=hsforEmailid.size();
		hsforkinid.add(name[9]);
		if(len2== hsforkinid.size())
		{
			System.out.println(name[9]+": KinId already exist..");
		}
		hsforEmailid.add(name[2]);
		if(len == hsforEmailid.size())
		{
			System.out.println(name[2]+": EmailId already exist..");
		}
		
		
		e.setName(name[0]);//employee setname
		e.setAddress(name[1]);//employee setAdress
		e.setEmailId(name[2]);//employee setEmailId
		e.setPhoneNo(num);//employee setPhnNo
		e.setDob(name[3]);//employee setDob
		e.setDoj(name[4]);//employee setDoj
		e.setKinId(name[9]);//employee setkinId
		d.setName(name[5]);//Department name setName
		d.setDepartmentId(num1);
		e.setDepartmentId(d.getDepartmentId());
		d.setDescription(name[6]);//Department description setdescription
		p.setName(name[7]);//project name setName
		p.setProjectId(num2);
		e.setProjectId(p.getProjectId());
		r.setName(name[8]);//Role Setname
		r.setRoleId(num3);
		e.setRolesId(r.getRoleId());
		Edao.AddEmployee(e);
		
		
		
	}
	
	public void	ModifyEmployee(String kinId){
		EmployeeDaoImplForList edao=new EmployeeDaoImplForList();
		edao.ModifyEmployee(kinId);
	}
	public void RemoveEmployee(String kinid){
		EmployeeDaoImplForList edao=new EmployeeDaoImplForList();
		edao.RemoveEmployee(kinid);
	}
	
	
	public void SearchEmployee(String search,int i){
		
		
		EmployeeDaoImplForList edao=new EmployeeDaoImplForList();
		edao.SearchEmployee(search, i);
			
	
			
		
		
	}
	
	
	public void getAllEmployee(){
		
		EmployeeDaoImplForList edao=new EmployeeDaoImplForList();
		edao.getAllEmployee();
		
	}
	
}
