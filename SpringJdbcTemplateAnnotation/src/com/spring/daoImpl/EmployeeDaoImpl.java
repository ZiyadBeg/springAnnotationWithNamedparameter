package com.spring.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Repository("employeedao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int addEmployeeDetails(Employee emp) {
//there are two ways which can help you to insert data into database
		// using map and sql parameter source
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", emp.getName());
		paramSource.addValue("addess", emp.getAddress());
		paramSource.addValue("email", emp.getEmail());
		String SQL = "insert into employee(name,address,email) values(:name,:addess,:email)";
		int status = namedParameterJdbcTemplate.update(SQL, paramSource);
		return status;
	}

	@Override
	public Employee getEmployeeById(long empid) {
		// TODO Auto-generated method stub
		String SQL = "Select * from employee where empid=:empid";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empid", empid);
		return 	namedParameterJdbcTemplate.queryForObject(SQL, map, new EmployeeRowMapper());
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return namedParameterJdbcTemplate.query("Select * from Employee", new EmployeeRowMapper());
	}

	@Override
	public int updateEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", emp.getName());
		map.put("address", emp.getAddress());
		map.put("email", emp.getEmail());
		map.put("empid", emp.getEmpid());
		String SQL = "update employee set name=:name,address=:address, email=:email where empid=:empid";
		return  namedParameterJdbcTemplate.update(SQL,map);
	}

	@Override
	public int deleteEmployee(long enmpid) {
		String SQL = "delete from employee where empid=:empid";
	int status= namedParameterJdbcTemplate.update(SQL,new HashMap<String,Object>(){{put("empid",enmpid);}});

		return status;
	}

}
