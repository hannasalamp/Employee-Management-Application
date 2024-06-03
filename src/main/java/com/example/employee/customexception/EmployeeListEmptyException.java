package com.example.employee.customexception;

public class EmployeeListEmptyException extends RuntimeException{
	public EmployeeListEmptyException() {
		super();
	}
	public EmployeeListEmptyException(String message) {
		super(message);
	}

}
