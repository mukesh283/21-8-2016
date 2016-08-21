package com.flp.ems.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="CAP_FLP_Employee")
public class Employee {
	
	//member variables
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;

    @NotEmpty(message="* Please Enter FirstName.")
	private String name;
    
    @NotEmpty(message="* Please Enter Kin id")
	private String kin_id;
    
	@NotEmpty(message="* Please Enter an email.")
	@Email(message="* Please Enter a valid email.")
	private String email_id; 
	
	private int phone_no;
	
	@Past(message="* Enter a valid past dob")
	private Date date_of_birth;
	
    @Future(message ="* Enter a valid future doj ")
    private Date date_of_joining;
    
    private String address;
    
    private String department;
    private String project;
    private String role;
    
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="departId_fk")
	private Department departments;
	
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectId_fk")
	private Project projects;
	
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId_fk")
	private Role roles;

    
    //constructor
	public Employee() {
		empId=-1;
	}


	//getter and setter
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getKin_id() {
		return kin_id;
	}


	public void setKin_id(String kin_id) {
		this.kin_id = kin_id;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public Date getDate_of_joining() {
		return date_of_joining;
	}


	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	

	public int getPhone_no() {
		return phone_no;
	}


	
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	
	public Department getDepartments() {
		return departments;
	}


	public void setDepartments(Department departments) {
		this.departments = departments;
	}


	public Project getProjects() {
		return projects;
	}


	public void setProjects(Project projects) {
		this.projects = projects;
	}


	public Role getRoles() {
		return roles;
	}


	public void setRoles(Role roles) {
		this.roles = roles;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
	
	


	
	
	
}
