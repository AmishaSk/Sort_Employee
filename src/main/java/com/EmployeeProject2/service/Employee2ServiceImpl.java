package com.EmployeeProject2.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeProject2.entity.Employee2;
import com.EmployeeProject2.repository.Employee2Repository;

@Service
public class Employee2ServiceImpl implements Employee2Service {

	@Autowired
	Employee2Repository employee2Repository;
	
	@Override
	public List<Employee2> getEmployeeDetails() {
		List<Employee2> response = (List<Employee2>) employee2Repository.findAll();
		if (response.isEmpty() || response == null) {
			throw new RuntimeException("Data is empty");
		}
		return response;
	}

	@Override
	public String saveEmployeeDetails(Employee2 employee) {
		Employee2 response=employee2Repository.save(employee);
		if(response==null) {
			throw new RuntimeException("Null");
		}
		return "Data saved successfully";
	}
	
	@Override
	public List<Employee2> findAllOrderByNameAsc(){
		List<Employee2> emp=(List<Employee2>) readAll();
		int s=emp.size();
		for(int i=0;i<s;i++) {
			for(int j=i+1;j<s;j++) {
				String a=emp.get(i).getFirstName()+" "+emp.get(i).getLastName();
				String b=emp.get(j).getFirstName()+" "+emp.get(j).getLastName();
				if(a.compareTo(b)>0) {
					Collections.swap(emp, i, j);
				}
			}
		}
		//return employee2Repository.findAllOrderByNameAsc();
		return emp;
	}
	
	private List<Employee2> readAll() {
		// TODO Auto-generated method stub
		return (List<Employee2>) employee2Repository.findAll();
	}

	@Override
	public List<Employee2> findAllOrderByAgeAsc(){
		List<Employee2> emp1=(List<Employee2>) readAll();
		int s=emp1.size();
		for(int i=0;i<s;i++) {
			for(int j=i+1;j<s;j++) {
				if(emp1.get(i).getAge()>emp1.get(j).getAge()) {
					Collections.swap(emp1, i, j);
				}
			}
		}
		//return employee2Repository.findAllOrderByAgeAsc();
		return emp1;
	}
}
