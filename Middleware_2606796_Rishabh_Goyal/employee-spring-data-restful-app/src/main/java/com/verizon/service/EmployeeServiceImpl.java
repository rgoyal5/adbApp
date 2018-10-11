package com.verizon.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.dao.EmployeeRepository;
import com.verizon.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Override
	public Employee getEmployeeById(long empId) {
		// TODO Auto-generated method stub
		Employee Employee = null;/*
		if(EmployeeRepo.existsById(EmployeeId))
		{
			Employee = EmployeeRepo.findById(EmployeeId).get();
		}*/
		//causes data base to be hit twice
		Optional<Employee> optEmployee =  EmployeeRepo.findById(empId);
		if(optEmployee.isPresent()){
			Employee =  optEmployee.get();
		}
		return Employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee Employee) {
		return EmployeeRepo.save(Employee);
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		return EmployeeRepo.save(Employee);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		boolean isDeleted=false;
		if(EmployeeRepo.existsById(empId)){
			EmployeeRepo.deleteById(empId);
			isDeleted=true;
		}
		
		return isDeleted;
	}
	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		return EmployeeRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public boolean existsByEmailId(String Employee) {
		// TODO Auto-generated method stub
		return EmployeeRepo.existsByEmailId(Employee);
	}

	@Override
	public Employee findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findByEmailId(emailId);
	}

	@Override
	public List<Employee> findAllByLastName(String lastName) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAllByLastName(lastName);
	}
	@Override
	public List<Employee> findAllByDept(String dept) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAllByDept(dept);
	}

	@Override
	public List<Employee> findAllByDateOfBirth(LocalDate dateOfBirth) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAllByDateOfBirth(dateOfBirth);
	}
}