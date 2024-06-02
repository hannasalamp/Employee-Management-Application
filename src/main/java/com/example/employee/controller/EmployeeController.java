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

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.repositories.DepartmentRepository;
import com.example.employee.services.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;
	@Autowired
	DepartmentRepository deRepository;
	
	@PostMapping(value="create")
	public String createEmployee(@RequestBody Employee e) {
		String msg=empServ.addEmlpoyee(e);
		return msg;	
	}
	
	@PutMapping(value="update/{empId}")
	public String updateEmployee(@PathVariable long empId, @RequestBody Employee e) {
		String msg=empServ.updateEmployee(empId, e);
		return msg;
	}
	@PutMapping(value="update-employeedepartment/{empId}")
	public String updateEmployeeDepartment(@PathVariable long empId, @RequestBody Department dep) {
		String msg=empServ.updateEmployeeDepartment(empId,dep);
		return msg;
	}
	
	
//	@GetMapping(value="get/{empId}")
//	public Employee getEmployeeInfo(@PathVariable String empId) {
//		Employee e=empServ.getEmployeeInfo(empId);
//		return e;
//	}
	
	@GetMapping(value="fetch-employees")
	public List<EmployeeDTO> getAllEmployee(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<EmployeeDTO> empListObjects = empServ.getAllEmployee(pageNo, pageSize);
		return empListObjects;
	}
	

//	@DeleteMapping(value="delete/{empId}")
//	public String deleteEmployee(@PathVariable String empId) {
//		String msg=empServ.deleteEmployee(empId);
//		return msg;
//	}
	
	@GetMapping(value="fetch-EmployeeDetails")
	public List<EmployeeDetailsDTO> getEmployeeNameWithId(@RequestParam boolean lookup){
		List<EmployeeDetailsDTO> empListobject=new ArrayList<>();
		if(lookup == true){
		  empListobject=empServ.getEmployeeNameWithId();
	    }
		return empListobject;
	}
}
