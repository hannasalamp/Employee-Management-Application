package com.example.employee.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.DepartmentDTO;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.ExpandDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.repositories.DepartmentRepository;
import com.example.employee.customexception.DepartmentAlreadyExistException;
import com.example.employee.customexception.DepartmentNotFoundException;
import com.example.employee.customexception.EmployeeFoundUnderDepartment;

@Service
public class DeptServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository deptRepo;
	
//	Implementing core logic for creating department
	@Override
	public String addDepartment(Department dept) { 
		List<Department> depList=new ArrayList<>();
		depList=deptRepo.findAll();
		for(Department dep:depList) {
			if(dep.getDeptName().equals(dept.getDeptName())) {
				throw new DepartmentAlreadyExistException("Department name is already Exist");
			}
		}
		dept.setDeptCreationDate(LocalDate.now());
	    deptRepo.save(dept);
		return "Department object is created and saved";
	}
//implementing core logic for updating department
	@Override
	public String updateDepartment(long depId, Department dept) {
		try {
			Department department=deptRepo.findById(depId).get();
			department.setDeptName(dept.getDeptName());
			department.setDeptCreationDate(LocalDate.now());
			department.setDeptHead(dept.getDeptHead());
			deptRepo.save(department);
		}
		catch(Exception ecxception) {
			throw new DepartmentNotFoundException("department with given Id doesn't exist");
		}
		return "department data is updated";
	}
//	implementing core logic for deleting department

	@Override
	public String deleteDepartment(long depId) {
		try {
			deptRepo.deleteById(depId);
		}
		catch(Exception exception) {
			throw new EmployeeFoundUnderDepartment("Can't delete the department as employee found in the department");
		}
		return "Department object is deleted";
	}
//implementing core logic for fetching all departments
	@Override
	public List<DepartmentDTO> getAllDepartment() {
		List<Department> depList=deptRepo.findAll();
		List<DepartmentDTO> depDtoList=new ArrayList<>();
		for(Department dep:depList) {
			DepartmentDTO depDto=new DepartmentDTO();
			depDto.setDeptId(dep.getDeptId());
			depDto.setDeptName(dep.getDeptName());
			depDto.setDeptCreationDate(dep.getDeptCreationDate());
			depDto.setDeptHead(dep.getDeptHead());
			depDtoList.add(depDto);
		}
		return depDtoList;
	}
//implementing logic for fetching all employees under a specific department
	@Override
	public ExpandDTO expandEmployeeUnderDepartment(long depId) {
	  ExpandDTO expandDTO=new ExpandDTO();
	  Department dep=deptRepo.findById(depId).get();
	    expandDTO.setDeptId(dep.getDeptId());
	    expandDTO.setDeptName(dep.getDeptName());
	    expandDTO.setDeptCreationDate(dep.getDeptCreationDate());
	    expandDTO.setDeptHead(dep.getDeptHead());
	  List<Employee> empList=dep.getEmp();
	  List<EmployeeDTO> empDtoList=new ArrayList<>();
	  for(Employee emp:empList){
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
			empDtoList.add(empDTO);
	  }
	  expandDTO.setEmployeeDTOList(empDtoList);
	  return expandDTO;
	}
}
