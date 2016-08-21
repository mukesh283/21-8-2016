package com.flp.ems.service;

import java.util.HashMap;

public interface IEmployeeService {
	
	public void AddEmployee(HashMap hm);
	public void	ModifyEmployee(String kinid);
	public void RemoveEmployee(String kinid);
	public void SearchEmployee(String search,int i);
	public void getAllEmployee();
}
