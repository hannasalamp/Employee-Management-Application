package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.DepartmentDTO;
import com.example.employee.dto.ExpandDTO;
import com.example.employee.entity.Department;
import com.example.employee.services.DepartmentService;


@RestController
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
//method handles POST requests to create a new Department
	@PostMapping(value="create")
	 public String addDepartment(@RequestBody Department dept) {
		String dp = deptService.addDepartment(dept);
		return dp; 
	 }
//method handles PUT request to update employee
	@PutMapping(value="update/{depId}")
	public String updateDepartment(@PathVariable long depId,@RequestBody Department dept){
		String dp=deptService.updateDepartment(depId,dept);
		return dp;
	}

//	method handles DELETE request to delete the department
	@DeleteMapping(value="delete/{depId}")
	public String deleteDepartment(@PathVariable long depId) {
		String dp=deptService.deleteDepartment(depId);
		return dp;
	}
//	method handles GET request to fetch all department
	
	@GetMapping(value="fetch-departments")
	public List<DepartmentDTO> getAllDepartment(){
		List<DepartmentDTO> deptListObjects=deptService.getAllDepartment();
		return deptListObjects;
	}
	
//	method handles GET request to fetch all employee's under a particular department
	@GetMapping(value="{depId}")
	public ExpandDTO expandEmployeeUnderDepartment(@PathVariable long depId ,@RequestParam String expand) {
		ExpandDTO expandDTO=new ExpandDTO();
		if(expand.equals("employee")) {
			expandDTO=deptService.expandEmployeeUnderDepartment(depId);	
		}
		return expandDTO;
	}
	
	
}
