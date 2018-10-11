package com.verizon.bsa.dao;

public interface IQueryMapper {
		
	public static final String INS_EMPLOYEE_QRY=
			"INSERT INTO employees VALUES(?,?,?,?,?)";
	public static final String DEL_EMPLOYEE_QRY=
			"DELETE FROM employees WHERE eid=?";
	public static final String UPDATE_EMPLOYEE_QRY=
			"UPDATE employees SET name=?,basic=?,hra=?,dept=? where eid=?";
	public static final String GET_EMPLOYEE_QRY=
			"SELECT * FROM employees WHERE eid=?";
	public static final String GET_ALL_QRY=
			"SELECT * FROM employees";
	
}
