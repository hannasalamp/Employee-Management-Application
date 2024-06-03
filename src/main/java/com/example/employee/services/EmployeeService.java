package com.example.employee.services;

import java.util.List;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;

public interface EmployeeService {
	//method signature for creating a new employee
	String addEmlpoyee(Employee e);
	
	//method signature for updating employee's details using employee Id
	String updateEmployee(long empId,Employee e);

	//method signature for updating employee's department
	String updateEmployeeDepartment(long empId,Department dep);
	
	//method signature for  fetch all employee's data with the support of pagination
	List<EmployeeDTO> getAllEmployee(int pageNo, int pageSize);
	
	List<EmployeeDetailsDTO> getEmployeeNameWithId(int pageNo,int pageSize);
	
	
}
