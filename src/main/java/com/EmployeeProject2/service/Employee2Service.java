package com.EmployeeProject2.service;

import java.util.List;

import com.EmployeeProject2.entity.Employee2;

public interface Employee2Service {

	 List<Employee2> getEmployeeDetails();
	String saveEmployeeDetails(Employee2 employee);

	List<Employee2> findAllOrderByNameAsc();
	List<Employee2> findAllOrderByAgeAsc();

}
