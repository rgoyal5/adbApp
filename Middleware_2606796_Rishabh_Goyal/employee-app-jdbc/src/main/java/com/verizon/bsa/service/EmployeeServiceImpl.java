package com.verizon.bsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.EmployeeDao;
import com.verizon.bsa.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public Employee add(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.add(employee);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.update(employee);
	}

	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(eid);
	}

	@Override
	public boolean deleteEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployeeById(eid);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}

}
