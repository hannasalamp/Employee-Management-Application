package com.example.employee.customexception;

public class DepartmentNotFoundException extends RuntimeException{
	public DepartmentNotFoundException() {
		super();
	}
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
