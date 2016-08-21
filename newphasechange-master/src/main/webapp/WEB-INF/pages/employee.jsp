<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.errMsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<form:form action="empSave" method="post" commandName="emp">
	<h2 align="center">Employee Form</h2>
	
	<table>
		
		<tr>
			<td>Name:</td>
			<td>
				<form:input path="name"/>
			</td>
			<td>
				<form:errors cssClass="errMsg" path="name"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Kin id:</td>
			<td>
				<form:input path="kin_id"/>
			</td>
			<td>
				<form:errors cssClass="errMsg" path="kin_id"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Email id:</td>
			<td>
				<form:input path="email_id"/>
			</td>
			<td>
		     <form:errors cssClass="errMsg" path="email_id"></form:errors>
		 </td>
		</tr>
		<tr>
			<td>PhoneNumber:</td>
			<td>
				<form:input path="phone_no"/>
			</td>
		</tr>
		
		<tr>
			<td>Date Of Birth:</td>
			<td>
				<form:input path="date_of_birth"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="date_of_birth"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Date Of Joining:</td>
			<td>
				<form:input path="date_of_joining"/>
			</td>
			<td>
			<form:errors cssClass="errMsg" path="date_of_joining"></form:errors>
			</td>
		</tr>
		<tr>
		<td>Address:</td>
		<td>
		    <form:input path="address"/>
		</td>
		</tr>
		<tr>
			<td>Choose Role:</td>
			<td>
				<c:if test="${!empty roles }">
				<form:select path="role">
					<c:forEach var="role" items="${roles}">
						<form:option value="${role.roleId}"> ${role.roleName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
		
		</tr>
		
		<tr>
			<td>Choose Project:</td>
			<td>
				<c:if test="${!empty projects }">
				<form:select path="project">
					<c:forEach var="project" items="${projects}">
						<form:option value="${project.projectId}"> ${project.projectName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
		
		</tr>
		
		<tr>
			<td>Choose Department:</td>
			<td>
				<c:if test="${!empty departments }">
				<form:select path="department">
					<c:forEach var="depart" items="${departments}">
						<form:option value="${depart.deptId}"> ${depart.deptName}</form:option>
					</c:forEach>
				
				</form:select>
				</c:if>
			</td>
		
		</tr>
	
		
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="save" value="Save">
			</td>
			<td>
			</td>
		</tr>
	
	</table>
	
</form:form>

<c:if test="${!empty employees }">
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>Name</th>
			<th>kin id</th>
			<th>Email id</th>
			<th>Phn-No</th>
			<th>DateOf Birth</th>
			<th>Date of joining</th>
			<th>Address</th>
			<th>Department</th>
			<th>Project</th>
			<th>Role</th>
			
		</tr>
		
		<c:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.name}</td>
			<td>${employee.kin_id}</td>
			<td>${employee.email_id}</td>
			<td>${employee.phone_no}</td>
			<td>${employee.date_of_birth}</td>
			<td>${employee.date_of_joining}</td>
			<td>${employee.address}</td>
			<td>${employee.departments.deptName}</td>
			<td>${employee.project}</td>
			<td>${employee.role}</td>
			<td>
				<a href="deleteEmployee/${employee.empId}">Delete</a>
				&nbsp;&nbsp;&nbsp;
				<a href="updateEmployee?id=${employee.empId}">Update</a>
			</td>
			
		</tr>
		</c:forEach>
	</table>

</c:if>
<table><form:form action="Search" method="post" commandName="emp">
<td>
				<form:input path="empId"/>
			</td>
			<td>
				<input type="submit" name="search" value="Search">
			</td>	
</form:form>
</table>
</body>
</html>