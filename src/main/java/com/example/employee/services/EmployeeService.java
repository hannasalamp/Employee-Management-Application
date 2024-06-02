package com.example.employee.services;

import java.util.List;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;

public interface EmployeeService {
	String addEmlpoyee(Employee e);
	//Employee getEmployeeInfo(String empId);
	String updateEmployee(long empId,Employee e);
	//String deleteEmployee(String empId);
	String updateEmployeeDepartment(long empId,Department dep);
	
	List<EmployeeDTO> getAllEmployee(int pageNo, int pageSize);
	
	List<EmployeeDetailsDTO> getEmployeeNameWithId();
}
