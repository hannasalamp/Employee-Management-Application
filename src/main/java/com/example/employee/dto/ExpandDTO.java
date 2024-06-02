package com.example.employee.dto;

import java.time.LocalDate;
import java.util.List;

public class ExpandDTO {
	private long deptId;
	private String deptName;
	private LocalDate deptCreationDate;
	private String deptHead;
	List<EmployeeDTO> employeeDTOList;
	public ExpandDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpandDTO(long deptId, String deptName, LocalDate deptCreationDate, String deptHead,
			List<EmployeeDTO> employeeDTOList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCreationDate = deptCreationDate;
		this.deptHead = deptHead;
		this.employeeDTOList = employeeDTOList;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public LocalDate getDeptCreationDate() {
		return deptCreationDate;
	}
	public void setDeptCreationDate(LocalDate deptCreationDate) {
		this.deptCreationDate = deptCreationDate;
	}
	public String getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	public List<EmployeeDTO> getEmployeeDTOList() {
		return employeeDTOList;
	}
	public void setEmployeeDTOList(List<EmployeeDTO> employeeDTOList) {
		this.employeeDTOList = employeeDTOList;
	}
	

}
