package com.example.employee.services;

import java.util.List;

import com.example.employee.dto.DepartmentDTO;
import com.example.employee.dto.ExpandDTO;
import com.example.employee.entity.Department;

public interface DepartmentService {
//method signature for creating an department
	String addDepartment(Department dept);
	
//	method signature for updating an department
	String updateDepartment(long depId,Department dept);
	
//	method signature for deleting an department
	String deleteDepartment(long depId);
	
// method signature for fetching all departments
	List<DepartmentDTO> getAllDepartment();
//	method signature for fetching all employee's under particular  department
	ExpandDTO expandEmployeeUnderDepartment(long depId);

	
}
