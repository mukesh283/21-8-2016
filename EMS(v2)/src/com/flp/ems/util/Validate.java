package com.flp.ems.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
private static Pattern NamePtrn = Pattern.compile("[a-zA-Z0-9-]+");//name pattern
private static Pattern Emailptrn= Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");//Email pattern
private static Pattern Kinptrn= Pattern.compile("[a-zA-Z0-9-]+");//KinId pattern
public static Pattern dateptrn=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
public static boolean validateName(String userName){
    Matcher mtch =NamePtrn.matcher(userName);
    if(mtch.matches()){
        return true;
    }
    return false;
}

public static boolean validateEmail(String userEmail){
    Matcher mtch =Emailptrn.matcher(userEmail);
    if(mtch.matches()){
        return true;
    }
    return false;
}
public static boolean validatePhnNo(long userPhn){
	int length = (int)(Math.log10(userPhn)+1);
	if(length==10)
		return true;
	else 
		return false;
  
	}

public static boolean validateKinId(String kinid){
	 Matcher mtch =Kinptrn.matcher(kinid);
	    if(mtch.matches()){
	        return true;
	    }
	    else
	    	return false;
  
	}
public static boolean validateDate(String dateToValidate){
	
	Matcher mtch =dateptrn.matcher(dateToValidate);
    if(mtch.matches()){
        return true;
    }
    else 
    	return false;
  
}

	}


