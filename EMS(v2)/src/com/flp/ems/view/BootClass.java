package com.flp.ems.view;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.flp.ems.domain.Employee;

public class BootClass {

public static void main(String[] args) {
	 int x=0;	
	do{
	System.out.println("Enter 1 to Create employee ");
	System.out.println("Enter 2 to Modify Employee Info");
	System.out.println("Enter 3 to Remove Employee");
	System.out.println("Enter 4 to View all employee");
	System.out.println("Enter 5 to Search employree by kinId,email Id");
	System.out.println("Enter 6 to exit the Operation");
	int userinput_value=0;
	try{
		Scanner sc = new Scanner(System.in);
		 userinput_value=sc.nextInt();}
	catch(InputMismatchException E){
		System.out.println("***Warning-->>>Enter from the above option only");
	}
	if(userinput_value==6)
		x=6;
	menuSelection(userinput_value);
	}while(x!=6);
System.out.println("Operation Successful");
}
public static void menuSelection(int userinput_value){
	
	UserInteraction ui=new UserInteraction();
	Employee e=new Employee();
	int value=userinput_value;
	
	switch(value)
	{
	case 1:
		ui.AddEmployee();
		break;
	case 2:
		ui.ModifyEmployee();
		break;
	case 3:
		ui.RemoveEmployee();
		break;
	case 4:
		ui.getAllEmployee();
		break;
	case 5:
		ui.SearchEmployee();
		break;
	//default:
		//System.out.println("wrong input");
	}
}
}
