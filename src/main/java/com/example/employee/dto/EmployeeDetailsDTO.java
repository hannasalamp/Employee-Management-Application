package com.example.employee.dto;

public class EmployeeDetailsDTO {
	
	private long empId;
	private String name;
	public EmployeeDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetailsDTO(long empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
