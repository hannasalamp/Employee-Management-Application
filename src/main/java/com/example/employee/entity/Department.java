package com.example.employee.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deptId;
	private String deptName;
	private LocalDate deptCreationDate;
	private String deptHead;
	@OneToMany(mappedBy="dept")
	private List<Employee> emp;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(long deptId, String deptName, LocalDate deptCreationDate, String deptHead, List<Employee> emp) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCreationDate = deptCreationDate;
		this.deptHead = deptHead;
		this.emp = emp;
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
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
}
