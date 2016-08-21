package com.flp.ems.domain;
public class Employee {
	/*Department department;
	Role role;
	Project project;*/
	String Name,Address,EmailId;
	int EmployeeId;
	String KinId;
	int DepartmentId,ProjectId,RolesId;
	long PhoneNo;
	String dob,doj;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	public String getAddress() {
		return Address;
	}
	
	public void setDob(String dob) {
		this.dob= dob;
	}
	public String getDob() {
		return dob;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
		public String getDoj() {
		return doj;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setPhoneNo(long phoneNo) {
		PhoneNo = phoneNo;
	}
	public long getPhoneNo() {
		return PhoneNo;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public int getDepartmentId() {
		return DepartmentId;
	}
	
	public int getEmployeeId() {
		return EmployeeId;
	}
	public String getKinId() {
		return KinId;
	}
	public void setKinId(String kinid)
	{
		KinId=kinid;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public int getProjectId() {
		 
		 return ProjectId;
	}
	public void setRolesId(int rolesId) {
		RolesId = rolesId;
	}
	public int getRolesId() {
		
		return RolesId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EmailId == null) ? 0 : EmailId.hashCode());
		result = prime * result + ((KinId == null) ? 0 : KinId.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Employee [KinId=" + KinId + ", EmailId=" + EmailId + ", Name=" + Name + ", DepartmentId=" + DepartmentId
				+ ", ProjectId=" + ProjectId + ", RolesId=" + RolesId + "]";
	}
	
	public boolean equals(String o) {
	//System.out.println("checking for duplicates...");

	if(KinId.equals(o) | EmailId.equals(o) | Name.equals(o))
	return true;
	return false;
	
}
	
	
	
}
