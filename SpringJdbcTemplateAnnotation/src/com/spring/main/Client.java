package com.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.EmployeeDao;
import com.spring.daoImpl.EmployeeDaoImpl;
import com.spring.model.Employee;

public class Client {

	public static void main(String[] args) {

		ApplicationContext appconytext = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeDao employeeDao = appconytext.getBean("employeedao", EmployeeDaoImpl.class);
		Employee emp = new Employee();
		emp.setEmpid(6);
		emp.setName("test");
		emp.setAddress("test");
		emp.setEmail("test@test.com");
		//getAllEmployeeDetails(employeeDao);
		//addEmployeeDetails(employeeDao, emp);
		// getEmployeeById(employeeDao,emp.getEmpid());
		// updateEmployee(employeeDao, emp);
		removeEmployee(employeeDao,emp.getEmpid());
	}

	private static void removeEmployee(EmployeeDao employeeDao, long empid) {
		int status =  employeeDao.deleteEmployee(empid);
		if (status > 0) {
			System.out.println("Sucessfully Deleted");
		} else {
			System.out.println("Not Deleted");
		}
	}

	private static void updateEmployee(EmployeeDao employeeDao, Employee emp) {
		int status = employeeDao.updateEmployeeDetails(emp);
		if (status > 0) {
			System.out.println("Sucessfully Update");
		} else {
			System.out.println("Not Update");
		}
	}

	private static void addEmployeeDetails(EmployeeDao employeeDao, Employee emp) {
		int status = employeeDao.addEmployeeDetails(emp);
		if (status > 0) {
			System.out.println("Sucessfully inserted");
		} else {
			System.out.println("Not Inserted");
		}
	}

	private static void getEmployeeById(EmployeeDao employeeDao, long empid) {
		Employee employee = employeeDao.getEmployeeById(empid);
		System.out.println(employee.getEmpid() + "\t" + employee.getName() + "\t" + employee.getEmail());
	}

	private static void getAllEmployeeDetails(EmployeeDao employeeDao) {
		List<Employee> emp = employeeDao.getAllEmployee();
		for (Employee employee : emp) {
			System.out.println(employee.getEmpid() + "\t" + employee.getName() + "\t" + employee.getEmail());
		}
	}

}
