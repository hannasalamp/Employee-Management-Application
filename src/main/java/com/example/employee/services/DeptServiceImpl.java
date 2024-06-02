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

@Service
public class DeptServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public String addDepartment(Department dept) {
		dept.setDeptCreationDate(LocalDate.now());
	    deptRepo.save(dept);
		return "Department object is created and saved";
	}

	@Override
	public String updateDepartment(long depId, Department dept) {
		Department department=deptRepo.findById(depId).get();
		department.setDeptName(dept.getDeptName());
		department.setDeptCreationDate(LocalDate.now());
		department.setDeptHead(dept.getDeptHead());
		deptRepo.save(department);
		return "department data is updated";
	}

	@Override
	public String deleteDepartment(long depId) {
		deptRepo.deleteById(depId);
		return "Department object is deleted";
	}

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
