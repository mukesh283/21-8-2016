package com.flp.ems.controller;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import javax.validation.Valid;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.service.EmployeeService;

	@Controller
	public class EmployeeController {

		@Autowired
		private EmployeeService employeeService;
		
		 Employee emp;
		 Department dept;
		 Project proj;
		 Role rol;
		 @ModelAttribute("emp")
		 public Employee getEmployee()
		 {
			 return new Employee();
		 }
		@RequestMapping(value={"/employeeForm","/updateEmployee"})
		public String showEmployeeForm(ModelMap map,@RequestParam(value="id",required=false) String employeeid){
			//Map<String, Object> map=new HashMap<>();
			int id;
			if(employeeid!=null)
				id=Integer.parseInt(employeeid);
			else
				id=-1;
			if(id!=-1){
			emp=employeeService.findById(id);
			System.out.println("Employee_id inside show EmployeeForm:"+emp.getEmpId());
			map.put("emp",emp);
		}
			map.put("departments", employeeService.getAllDepartments());
			map.put("projects", employeeService.getAllProjects());
			map.put("roles", employeeService.getAllRoles());
			map.put("employees", employeeService.getAllEmployees());
			
			return "employee";
		}
		
		
		@RequestMapping(value="/empSave",method=RequestMethod.POST)
		public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
				
				BindingResult results,ModelMap map){
			proj=employeeService.findProject(employee.getProject());
			dept=employeeService.findDepartment(employee.getDepartment());
			rol=employeeService.findRole(employee.getRole());
			employee.setDepartments(dept);
			employee.setProjects(proj);
			employee.setRoles(rol);
			System.out.println(employee);
			System.out.println("Employee_id in save :"+employee.getEmpId());
			map.put("employees", employeeService.getAllEmployees());
			map.put("departments", employeeService.getAllDepartments());
			map.put("projects", employeeService.getAllProjects());
			map.put("roles", employeeService.getAllRoles());
			if(results.hasErrors()){
				return "employee";
			}else{
				if(employee.getEmpId() == -1){
					employeeService.saveEmployee(employee);
					}
				else{
					employeeService.updateEmployee(employee);
					}
				return "redirect:employeeForm";
			}
		}
		
		
		

		
		@RequestMapping("/deleteEmployee/{empId}")
		public String deleteEmployee(@PathVariable("empId") Integer employeeId){
			employeeService.deleteEmployee(employeeId);
			
			return "redirect:/employeeForm";
		}
		
		@RequestMapping("/findemployee")
		public String findEmployee(){
			return "search";
		}
		
		@RequestMapping("/Search")
		public String SearchEmployee(ModelMap map,@RequestParam(value="empId",required=false) int employeeid){
			System.out.println(employeeid);
			if(employeeid!=-1)
				emp=employeeService.findById(employeeid);
			List<Employee> list=new ArrayList<>();
			list.add(emp);
			System.out.println(emp);
			
			map.put("employees",list);
			map.put("departments", employeeService.getAllDepartments());
			map.put("projects", employeeService.getAllProjects());
			map.put("roles", employeeService.getAllRoles());
			return "employee";	
		}
	}
		
		
		
		
		
		
		

