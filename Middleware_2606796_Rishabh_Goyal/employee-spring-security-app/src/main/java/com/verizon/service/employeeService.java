package com.verizon.service;

import java.time.LocalDate;
import java.util.List;

import com.verizon.model.Employee;

public interface employeeService {

	Employee getEmployeeById(long EmployeeId);
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee Employee);
	Employee updateEmployee(Employee Employee);
	boolean deleteEmployee(long EmployeeId);
	
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	Employee);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	
	List<Employee> findAllByLastName(String lastName);
	List<Employee> findAllByDept(String dept);
	List<Employee> findAllByDateOfBirth(LocalDate dateOfBirth);
	
	
	}