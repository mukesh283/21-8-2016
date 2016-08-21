package com.flp.ems.domain;

public class Project {

	int ProjectId,DepartmentId;
	String Name,Description;
	public int getProjectId() {
		
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
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
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	
}
