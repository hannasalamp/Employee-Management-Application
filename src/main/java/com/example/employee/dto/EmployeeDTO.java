package com.example.employee.dto;

import java.time.LocalDate;

public class EmployeeDTO {
	private long empId;
	private String name;
	private LocalDate dob;
	private float salary;
	private String address;
	private String role;
	private LocalDate joiningDate;
	private float yearlyBonus;
	private String reportingManager;
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(long empId, String name, LocalDate dob, float salary, String address, String role,
			LocalDate joiningDate, float yearlyBonus, String reportingManager) {
		super();
		this.empId = empId;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.role = role;
		this.joiningDate = joiningDate;
		this.yearlyBonus = yearlyBonus;
		this.reportingManager = reportingManager;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public float getYearlyBonus() {
		return yearlyBonus;
	}
	public void setYearlyBonus(float yearlyBonus) {
		this.yearlyBonus = yearlyBonus;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	

}
