package com.verizon.bsa.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.verizon.bsa.model.Employee;

@Repository
public class EmployeeDaoJDBCImpl implements EmployeeDao {
private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public EmployeeDaoJDBCImpl(DataSource datasource){
		this.jdbcTemplate =new JdbcTemplate(datasource);
	}
	@Override
	public Employee add(Employee employee) {
	int count =jdbcTemplate.update(IQueryMapper.INS_EMPLOYEE_QRY,
				employee.getEid(),
				employee.getName(),
				employee.getBasic(),
				employee.getHra(),
				employee.getDept());
		if(count<1){
			employee=null;
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee) {

		int count =jdbcTemplate.update(IQueryMapper.UPDATE_EMPLOYEE_QRY,
				
				employee.getName(),
				employee.getBasic(),
				employee.getHra(),
				employee.getDept(),
				employee.getEid());
		if(count<1){
			employee=null;
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		List<Employee> employees= jdbcTemplate.query(IQueryMapper.GET_EMPLOYEE_QRY,
				new Object[] {eid},
				new EmployeeRowMapper());
		Employee employee=null;
		if(employees!=null && employees.size()==1)
			employee=employees.get(0);
		
		return employee;
	}
	@Override
	public boolean deleteEmployeeById(int eid) {
		boolean isDeleted=false;
		
		int count=jdbcTemplate.update(IQueryMapper.DEL_EMPLOYEE_QRY,eid);
		
		if(count>1)
			isDeleted=true;
		
		return isDeleted;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees= jdbcTemplate.query(IQueryMapper.GET_ALL_QRY,
				new EmployeeRowMapper());
		return employees;
	}

}
