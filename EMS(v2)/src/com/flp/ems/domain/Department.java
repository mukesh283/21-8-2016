package com.flp.ems.domain;


public class Department {

	 int DepartmentId;
	String Name,Description;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setDepartmentId(int i) {
		DepartmentId =i;
	}
	public int getDepartmentId() {
		return DepartmentId;
	}
	
	
	
	}

