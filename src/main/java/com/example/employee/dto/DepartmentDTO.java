package com.example.employee.dto;

import java.time.LocalDate;

public class DepartmentDTO {
	private long deptId;
	private String deptName;
	private LocalDate deptCreationDate;
	private String deptHead;
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDTO(long deptId, String deptName, LocalDate deptCreationDate, String deptHead) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCreationDate = deptCreationDate;
		this.deptHead = deptHead;
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
	

}
