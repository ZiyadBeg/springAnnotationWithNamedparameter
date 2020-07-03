package com.spring.model;

public class Employee {

	private long empid;
	private String name;
	private String address;
	private String email;

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(int empid, String name, String address, String email) {
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public Employee() {
	}
}
