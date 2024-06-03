package com.example.employee.customexception;

public class EmployeeFoundUnderDepartment extends RuntimeException{
	public EmployeeFoundUnderDepartment() {
		super();
	}
	public EmployeeFoundUnderDepartment(String message ) {
		super(message);
	}
	
}
