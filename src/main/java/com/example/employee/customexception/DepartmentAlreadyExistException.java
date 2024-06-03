package com.example.employee.customexception;

public class DepartmentAlreadyExistException extends RuntimeException {
	public DepartmentAlreadyExistException() {
		super();
	}
	public DepartmentAlreadyExistException(String message) {
		super(message);
	}

}
