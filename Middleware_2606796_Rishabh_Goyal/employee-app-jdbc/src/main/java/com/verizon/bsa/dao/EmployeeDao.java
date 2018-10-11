package com.verizon.bsa.dao;

import java.util.List;

import com.verizon.bsa.model.Employee;

public interface EmployeeDao {

	Employee add(Employee employee);
	Employee update(Employee employee);
	Employee getEmployeeById(int eid);
	boolean deleteEmployeeById(int eid);
	List<Employee> getAll();
}
