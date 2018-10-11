package com.verizon.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.verizon.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	Employee);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	
	List<Employee> findAllByLastName(String lastName);
	List<Employee> findAllByDept(String dept);
	List<Employee> findAllByDateOfBirth(LocalDate dateOfBirth);
	}