package com.verizon.bsa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.verizon.bsa.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=new Employee();
		
		emp.setEid(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setBasic(rs.getDouble(3));
		emp.setHra(rs.getInt(4));
		emp.setDept(rs.getString(5));
		
		
		return emp;
	}

}
