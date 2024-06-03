package com.example.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value = "SELECT * FROM Employee WHERE address = :address", nativeQuery = true)
	public Employee findByAddress(@Param("address") String address);
}
