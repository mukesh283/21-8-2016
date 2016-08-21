package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;
public class UserInteraction {
	
public void AddEmployee()
	{
	
	EmployeeServiceImpl empl=new EmployeeServiceImpl();
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Name:");
		boolean flag=true;
	    String name1 = sc.nextLine();  
		flag=Validate.validateName(name1);
	 if(flag==false){
			 System.out.println("wrong input...ReEnter the valid name");
			 return;
	 }
		System.out.println("Enter the Address:");
		String ad=sc.nextLine();
		System.out.println("Enter the EmailId:");
		
		String emailid=sc.nextLine();
		flag=Validate.validateEmail(emailid);
		if(flag==false){
			System.out.println("Invalid EmailId***");
			return;
		}
		System.out.println("Enter Phn no...it must be 10 digit number");
		Scanner input=new Scanner(System.in);
		long phn=input.nextLong();
		flag=Validate.validatePhnNo(phn);
		if(flag==false){
			System.out.println("wrong PhnNo format");
			return;
		}
		System.out.println("Enter KinId");
		Scanner s=new Scanner(System.in);
		String kinId=s.nextLine();
		flag=Validate.validateKinId(kinId);
		if(flag==false){
			System.out.println("wrong kinid");
			return ;
		}
		
		System.out.println("Enter DOB in dd/mm/yyyy format");
		Scanner sc1=new Scanner(System.in);
		String dob=sc1.nextLine();
		flag=Validate.validateDate(dob);
		if(flag==false){
			System.out.println("invalid date format");
			return;
		}
		System.out.println("enter DOJ in dd/mm/yyyy format");
		String doj=sc1.nextLine();
		flag=Validate.validateDate(doj);
		if(flag==false){
			System.out.println("invalid format");
			return;
		}
		System.out.println("Department list");
		String[] str={"FS","NFS"};
		System.out.println("FS,NFS");
		int i=0;
		try{
		System.out.println("enter 1 for FS,enter 2 for NFS");
		
		i=sc1.nextInt();
		}
		catch(Exception e){
			System.out.println("please enter from above option");
		}
		int depid=0;
		String departname = null;
		String description1 = null;
		String projname=null;
		int pid=0;
			switch(i){
		
		case 1:
			departname=str[0];
			depid=10;
			description1="Financial Sevice";
			System.out.println("select project from the given list");
			String[] project={"A","B","C"};
			System.out.println(project[0]+"\n"+project[1]+"\n"+project[2]);
			System.out.println("enter 1 for A,enter 2 for B,enter 3 for C");
			Scanner num=new Scanner(System.in);
			int n=num.nextInt();
			switch(n){
			case 1:
				projname=project[0];
				pid=48;
				break;
			case 2:
				projname=project[1];
				pid=49;
				break;
			case 3:
				projname=project[2];
				pid=50;
				break;
			}
			
			break;
		case 2:
			departname=str[1];
			depid=11;
			description1="NonFinancial Service";
			String[] proj={"D","E","F"};
			
			System.out.println(proj[0]+"\n"+proj[1]+"\n"+proj[2]);
			System.out.println("enter 1 for D,enter 2 for E,enter 3 for F");
			Scanner a=new Scanner(System.in);
			int d=a.nextInt();
			switch(d){
			case 1:
				projname=proj[0];
				pid=100;
				break;
			case 2:
				projname=proj[1];
				pid=101;
				break;
			case 3:
				projname=proj[2];
				pid=102;
				break;
			}
			
			break;
			
			default:
				System.out.println("wrong input");
		}
		/*System.out.println("Enter projectname");
		Scanner sc2 = new Scanner(System.in);
		String projname=sc2.nextLine();*/
		System.out.println("Enter Rolename");
		System.out.println("enter 1 for software engineer");
		System.out.println("enter 2 for consultant");
		System.out.println("enter 3 for HR");
		Scanner num=new Scanner(System.in);
		int option=num.nextInt();
		int roleid=0;
		String rolename=null;
		switch(option){
		case 1:
			rolename="Software Engineer";
			roleid=1;
			break;
		case 2:
			rolename="consultant";
			roleid=2;
			break;
		case 3:
			rolename="HR";
			roleid=3;
			break;
		default:
				System.out.println("enter a valid input");
		}
		
		
		HashMap hm=new HashMap();
		hm.put(1,name1);
		hm.put(2, ad);
		hm.put(3, emailid);
		hm.put(4,phn);
		hm.put(5,dob);
		hm.put(6,doj);
		hm.put(7,departname);
		hm.put(8,description1);
		hm.put(9,projname);
		hm.put(10,rolename);
		hm.put(11, kinId);
		hm.put(12,depid);
		hm.put(13, pid);
		hm.put(14,roleid);
		empl.AddEmployee(hm);
	}

public void SearchEmployee() 
	{
	System.out.println("search by kinid,or emailid or name");
	System.out.println("1 to search by kinid");
	System.out.println("2 to search by emailId");
	System.out.println("3 to search by name");
	Scanner sc=new Scanner(System.in);
	EmployeeServiceImpl es=new EmployeeServiceImpl();
	int i=sc.nextInt();
	switch(i){
	case 1:
	System.out.println("enter the kin id to search");
	Scanner sc1=new Scanner(System.in);
	String searchby_kinid=sc1.nextLine();
	es.SearchEmployee(searchby_kinid,1);
	break;
	case 2:
		System.out.println("enter the emailid to search");
		Scanner sc3=new Scanner(System.in);
		String searchby_email=sc3.nextLine();
		es.SearchEmployee(searchby_email,2);
		break;
	case 3:
		System.out.println("Enter the name to search the employee");
		Scanner sc4=new Scanner(System.in);
		String searchby_name=sc4.nextLine();
		es.SearchEmployee(searchby_name,3);
		break;
	}
		
	}

public void ModifyEmployee() 
    {
	
	EmployeeServiceImpl es=new EmployeeServiceImpl();
	System.out.println("enter kinid to update or modify");
	Scanner sc=new Scanner(System.in);
	String kinid=sc.nextLine();
	es.ModifyEmployee(kinid);
	
	}

public void RemoveEmployee() 
	{
	EmployeeServiceImpl es=new EmployeeServiceImpl();
	System.out.println("enter kinid to remove that employee");
	Scanner sc=new Scanner(System.in);
	String kin=sc.nextLine();
	es.RemoveEmployee(kin);
	
	}

public void getAllEmployee() 
	{
		EmployeeServiceImpl es=new EmployeeServiceImpl();
		es.getAllEmployee();
	}
}
