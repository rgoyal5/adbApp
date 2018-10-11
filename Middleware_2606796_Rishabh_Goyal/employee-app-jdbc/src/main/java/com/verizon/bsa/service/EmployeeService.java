package com.verizon.bsa.service;

import java.util.List;

import com.verizon.bsa.model.Employee;

public interface EmployeeService {
	
	Employee add(Employee employee);
	Employee update(Employee employee);
	Employee getEmployeeById(int eid);
	boolean deleteEmployeeById(int eid);
	List<Employee> getAll();

}
