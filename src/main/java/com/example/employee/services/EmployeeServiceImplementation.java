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


@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	DepartmentRepository departRepository;

	@Override
	public String addEmlpoyee(Employee e) {
		emprepo.save(e);
		return "Employee Object is created and saved";
	}

//	@Override
//	public Employee getEmployeeInfo(String empId) {
//		Employee e=emprepo.findById(empId).get();
//	return null;
//	}

	

	@Override
	public String updateEmployee(long empId,Employee e) {
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
		
		return "Employee Object is updated";
	}

//	@Override
//	public String deleteEmployee(String empId) {
//		emprepo.deleteById(empId);
//		return "Employee object is deleted";
//	}

	@Override
	public String updateEmployeeDepartment(long empId,Department dep) {
		Employee employee=emprepo.findById(empId).get();
		employee.setDept(dep);
		emprepo.save(employee);
		return "employee's department object is updated" ;
	}
	
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

	@Override
	public List<EmployeeDetailsDTO> getEmployeeNameWithId() {
		List<Employee> empList = emprepo.findAll();
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
