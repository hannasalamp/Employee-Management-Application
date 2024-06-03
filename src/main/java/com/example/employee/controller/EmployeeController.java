package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.customexception.EmployeeNotFoundException;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.services.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;
	
//	method handles POST requests to create a new employee
	@PostMapping(value="create")
	public String createEmployee(@RequestBody Employee e) {
		String msg=empServ.addEmlpoyee(e);
		return msg;	
	}
	
//	method handles PUT requests to update an existing employee's details using the employee ID.
	@PutMapping(value="update/{empId}")
	public String updateEmployee(@PathVariable long empId, @RequestBody Employee e) {
		String msg=empServ.updateEmployee(empId, e);
		return msg;
	}
	
//	method handles PUT requests to update an employee's department.
	@PutMapping(value="update-employeedepartment/{empId}")
	public String updateEmployeeDepartment(@PathVariable long empId, @RequestBody Department dep) {
		String msg=empServ.updateEmployeeDepartment(empId,dep);
		return msg;
	}
	
	
	//	method handles GET requests to fetch all employees with pagination support.
	@GetMapping(value="fetch-employees")
	public List<EmployeeDTO> getAllEmployee(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<EmployeeDTO> empListObjects = empServ.getAllEmployee(pageNo, pageSize);
		return empListObjects;
	}
	


// method handles GET requests to fetch all Employee Id with their corresponding name
	@GetMapping(value="fetch-EmployeeDetails")
	public List<EmployeeDetailsDTO> getEmployeeNameWithId(@RequestParam(required = true) String lookup,@RequestParam int pageNo, @RequestParam int pageSize){
		List<EmployeeDetailsDTO> empListobject=new ArrayList<>();
		if(lookup.equals("true")){
		  empListobject=empServ.getEmployeeNameWithId(pageNo,pageSize);
	    } 
		return empListobject;
	}
}
