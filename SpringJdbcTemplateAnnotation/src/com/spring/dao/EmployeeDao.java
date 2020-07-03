package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {
public abstract int addEmployeeDetails(Employee emp);
public abstract Employee getEmployeeById(long empid);
public abstract List<Employee> getAllEmployee();
public abstract  int updateEmployeeDetails(Employee emp);
public abstract int deleteEmployee(long enmpid);

}
