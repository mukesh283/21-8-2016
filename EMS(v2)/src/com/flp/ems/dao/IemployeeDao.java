package com.flp.ems.dao;

import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {

	public void AddEmployee(Employee e);
	public void	ModifyEmployee(String s);
	public void RemoveEmployee(String kinid);
	public void SearchEmployee(String search,int i);
	public void getAllEmployee();
}
