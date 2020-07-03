package com.spring.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rownum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpid(rs.getLong("empid"));
		emp.setName(rs.getString("name"));
		emp.setAddress(rs.getString("address"));
		emp.setEmail(rs.getString("email"));
		return emp;
	}

}
