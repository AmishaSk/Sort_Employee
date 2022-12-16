package com.EmployeeProject2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeedetails")
public class Employee2{
	@Id
	@Column(name= "empid" )
	private long empid;
	@Column(name= "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name="age")
	private int age;
	@Column(name="salary")
	private double salary;
	
	
	public Employee2() {
		
	}
	public Employee2(long empid, String firstName, String lastName, int age, double salary) {
		super();
		this.empid=empid;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.salary=salary;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		var builder=new StringBuilder();
		builder.append("Employee2{empid=").append(empid).append(", firstName=").append(firstName).append(", lastName=").append(lastName)
		.append(", age=").append(age).append(", salary=").append(salary);
		return builder.toString();
	}
}
