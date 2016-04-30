package com.example.rbspinginmemdb.main;

public class Employee {
	String id;
	String name;
	String dob;
	int salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, dob=%s, salary=%s]", id, name, dob, salary);
	}
	
	
}
