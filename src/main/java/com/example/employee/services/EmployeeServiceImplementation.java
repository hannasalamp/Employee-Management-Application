package com.example.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.repositories.DepartmentRepository;
import com.example.employee.repositories.EmployeeRepository;
import com.example.employee.customexception.DepartmentNotFoundException;
import com.example.employee.customexception.EmployeeListEmptyException;
import com.example.employee.customexception.EmployeeNotFoundException;


@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	DepartmentRepository departRepository;
	
//Implementing core logic for creating new employee
	@Override
	public String addEmlpoyee(Employee e) {
		emprepo.save(e);
		return "Employee Object is created and saved";
	}

//Implementing core logic for updating employee detail's by using employee's Id
	@Override
	public String updateEmployee(long empId,Employee e){
		try {
			Employee employee = emprepo.findById(empId).get();
			employee.setAddress(e.getAddress());
		    employee.setDob(e.getDob());
			employee.setName(e.getName());
			employee.setSalary(e.getSalary());
			employee.setRole(e.getRole());
			employee.setJoiningDate(e.getJoiningDate());
			employee.setYearlyBonus(e.getYearlyBonus());
			employee.setReportingManager(e.getReportingManager());
			employee.setDept(e.getDept());
			emprepo.save(employee);
		}catch(Exception exception) {
			throw new EmployeeNotFoundException("Employee with the given Id doesn't exist");
		}
		return "Employee Object is updated";
	}


//Implementing core logic for updating employee's department
	@Override
	public String updateEmployeeDepartment(long empId,Department dep) {
			Employee employee=new Employee();
		try {
			employee=emprepo.findById(empId).get();
		}
		catch(Exception exception) {
			throw new EmployeeNotFoundException("Employee with the id doesn't exist");
		}
		try {
			Department department=departRepository.findById(dep.getDeptId()).get();
			employee.setDept(dep);
			emprepo.save(employee);
		}
		catch(Exception exception) {
			throw new DepartmentNotFoundException("Department with the id doesn't exist");
		}
		return "employee's department object is updated" ;
	}
	
//	Implementing core logic to fetch all the employee's  with pagination support
	@Override
	public List<EmployeeDTO> getAllEmployee(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> empList = emprepo.findAll(pageable);
		List<EmployeeDTO> empDTOList = new ArrayList<>();
		for(Employee emp: empList) {
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setAddress(emp.getAddress());
			empDTO.setEmpId(emp.getEmpId());
			empDTO.setName(emp.getName());
			empDTO.setSalary(emp.getSalary());
			empDTO.setRole(emp.getRole());
			empDTO.setDob(emp.getDob());
			empDTO.setYearlyBonus(emp.getYearlyBonus());
			empDTO.setJoiningDate(emp.getJoiningDate());
			empDTO.setReportingManager(emp.getReportingManager());
			empDTOList.add(empDTO);
		}
		return empDTOList;
	}
	
//	implementing core logic to fetch all employee id with their names

	@Override
	public List<EmployeeDetailsDTO> getEmployeeNameWithId(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> empList = emprepo.findAll(pageable);
		if(empList.isEmpty()) {
			throw new EmployeeListEmptyException("employee list is empty");
		}
		List<EmployeeDetailsDTO> empDTOLists = new ArrayList<>();
		for(Employee emp:empList) {
			EmployeeDetailsDTO empDto=new EmployeeDetailsDTO();
			empDto.setEmpId(emp.getEmpId());
			empDto.setName(emp.getName());
			empDTOLists.add(empDto);
		}
		return empDTOLists;
	}
	

}
