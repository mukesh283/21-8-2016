package com.flp.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.service.EmployeeServiceImpl;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class EmployeeDaoImplForList implements IemployeeDao{


	//static ArrayList<Employee> arraylist=new ArrayList<Employee>();
	@Override
	public void AddEmployee(Employee e) {
		try {
			
		
	Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?)");
	ps.setInt(1, e.getEmployeeId());
	ps.setString(2, e.getName());
	try{
	ps.setString(3,e.getKinId());
	}
	catch(MySQLIntegrityConstraintViolationException s)
	{
		 System.out.println("duplicate....");
	}
	ps.setString(4, e.getEmailId());
	ps.setLong(5,e.getPhoneNo());
	ps.setString(6,e.getDob());
	ps.setString(7,e.getDoj());
	ps.setString(8, e.getAddress());
    ps.setInt(9,e.getDepartmentId());
	ps.setInt(10, e.getProjectId());
	ps.setInt(11, e.getRolesId());
    ps.executeUpdate();
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public void ModifyEmployee(String kinid) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		PreparedStatement ps=con.prepareStatement("select * from employee where kinid=?");
		ps.setString(1,kinid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){  
			System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9));  
			}  }
		catch(Exception e){
			e.printStackTrace();
		}
			int x=1;
			
			while(x==1){
			System.out.println("enter 1 to update name");
			System.out.println("enter 2 to update address");
			System.out.println("enter 3 to update emailId");
			System.out.println("enter 4 to update kin id");
			System.out.println("enter 5 to update PhnoneNo");
			System.out.println("enter 6 to go ahead");
			Scanner sc=new Scanner(System.in);
			int j=sc.nextInt();
			
			switch(j){
			case 1:
				System.out.println("Enter Name");
				Scanner sc1=new Scanner(System.in);
				String nm=sc1.nextLine();
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
				PreparedStatement stmt=con.prepareStatement("update employee set name=? where kinid=?");  
				stmt.setString(1,nm);//1 specifies the first parameter in the query i.e. name  
				stmt.setString(2,kinid); 
				stmt.executeUpdate();
				}
				catch(Exception e){
				e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter Address");
				Scanner sc2=new Scanner(System.in);
				String ad=sc2.nextLine();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
				PreparedStatement stmt1=con.prepareStatement("update employee set address=? where kinid=?");  
				stmt1.setString(1,ad);//1 specifies the first parameter in the query i.e. name  
				stmt1.setString(2,kinid); 
				stmt1.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter EmailId");
				Scanner sc3=new Scanner(System.in);
				String emailid=sc3.nextLine();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			
				PreparedStatement stmt2=con.prepareStatement("update employee set emailid=? where kinid=?");  
				stmt2.setString(1,emailid);//1 specifies the first parameter in the query i.e. name  
				stmt2.setString(2,kinid); 
				stmt2.executeUpdate();
				}
				catch(Exception e){
				e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter KinId");
				Scanner sc4=new Scanner(System.in);
				String value=sc4.nextLine();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			
					PreparedStatement stmt3=con.prepareStatement("update employee set kinid=? where kinid=?");  
					stmt3.setString(1,value);//1 specifies the first parameter in the query i.e. name  
					stmt3.setString(2,kinid); 
					stmt3.executeUpdate();
					}
					catch(Exception e){
					e.printStackTrace();
					}
				
				break;
			case 5:
				System.out.println("Enter phnNo");
				Scanner sc5=new Scanner(System.in);
				long phn=sc5.nextLong();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			
					PreparedStatement stmt2=con.prepareStatement("update employee set phoNo=? where kinid=?");  
					stmt2.setLong(1,phn);//1 specifies the first parameter in the query i.e. name  
					stmt2.setString(2,kinid); 
					stmt2.executeUpdate();
					}
					catch(Exception e){
					e.printStackTrace();
					}
			case 6:
				x=2;
				break;
			
			}
			}
				
	}
				
	
		
		
	

	@Override
	public void RemoveEmployee(String kinid) {
	try{	
		
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
	PreparedStatement ps=con.prepareStatement("select * from employee where kinid=?");
	ps.setString(1,kinid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){  
		System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9));  
		}  
	PreparedStatement ps1=con.prepareStatement("delete from employee where kinid=?");
	ps1.setString(1, kinid);
	ps1.executeUpdate();
	System.out.println("employee with the above data has been removed from the database");
	
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

	@Override
	
	public void SearchEmployee(String search,int i) {
		System.out.println("searching employee...");
		switch(i){
		case 1:
			try{Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			PreparedStatement ps=con.prepareStatement("select * from employee where kinid=?");
			ps.setString(1,search);
			ResultSet rs=ps.executeQuery();
			int x=0;
			while(rs.next()){
				x++;
			System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9)+",Projectid="+rs.getInt(10)+",Roleid="+rs.getInt(11));
			}
			if(x==0){
				System.out.println("Employee with kind="+search+" doesn't exist in Database");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		break;
		case 2:
			try{Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			PreparedStatement ps=con.prepareStatement("select * from employee where emailid=?");
			ps.setString(1,search);
			ResultSet rs=ps.executeQuery();
			int y=0;
			while(rs.next()){
				y++;
			System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9)+",Projectid="+rs.getInt(10)+",Roleid="+rs.getInt(11));
			}
			if(y==0){
				System.out.println("Employee with Emailid="+search+" doesn't exist in Database");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			break;
		case 3:
			try{Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			PreparedStatement ps=con.prepareStatement("select * from employee where name=?");
			ps.setString(1,search);
			ResultSet rs=ps.executeQuery();
			int y=0;
			while(rs.next()){
				y++;
			System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9)+",Projectid="+rs.getInt(10)+",Roleid="+rs.getInt(11));
			}
			if(y==0){
				System.out.println("Employee with Name="+search+" doesn't exist in Database");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			break;
			
		}
		}
	

	@Override
	public void getAllEmployee() {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		PreparedStatement ps=con.prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){  
		System.out.println("Kinid="+rs.getString(3)+",Emailid= "+rs.getString(4)+",Name= "+rs.getString(2)+",Deparmentid="+rs.getInt(9)+",Projectid="+rs.getInt(10)+",Roleid="+rs.getInt(11));
		
		}
		
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	}

