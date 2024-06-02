package com.example.employee.services;

import java.util.List;

import com.example.employee.dto.DepartmentDTO;
import com.example.employee.dto.ExpandDTO;
import com.example.employee.entity.Department;

public interface DepartmentService {

	String addDepartment(Department dept);
	
	String updateDepartment(long depId,Department dept);
	
	String deleteDepartment(long depId);

	List<DepartmentDTO> getAllDepartment();

	ExpandDTO expandEmployeeUnderDepartment(long depId);

	
}
