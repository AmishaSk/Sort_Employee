package com.EmployeeProject2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeProject2.entity.Employee2;
import com.EmployeeProject2.service.Employee2Service;

@RestController
@RequestMapping("/employeedb")

public class Employee2Controller {

	@Autowired
	Employee2Service employee2Service;
	
	@PostMapping("save")
	public ResponseEntity<String> addEmploye(@RequestBody Employee2 employee) {
		String response = employee2Service.saveEmployeeDetails(employee);
		if(response == null || response.isEmpty()) {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not saved");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/get-all")
	public ResponseEntity<List<Employee2>> getAllEmployeeDetails(){
		List<Employee2> response=employee2Service.getEmployeeDetails();
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@GetMapping("/age")
	public List<Employee2> getDetailsByAge(){
		return employee2Service.findAllOrderByAgeAsc();
	}
	@GetMapping("/name")
	public List<Employee2> getDetailsByName(){
		return employee2Service.findAllOrderByNameAsc();
		
	}
}
