package com.EmployeeProject2;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import com.EmployeeProject2.entity.Employee2;
import com.EmployeeProject2.repository.Employee2Repository;
import com.EmployeeProject2.service.Employee2ServiceImpl;

@SpringBootTest
class EmployeeProject2ApplicationTests {
	
	@Mock
	private Employee2Repository employee2Repository;
	@InjectMocks
	private Employee2ServiceImpl employee2Service;
	
	private Employee2 employee2;
	
	List<Employee2> listemp=new ArrayList<Employee2>();
	List<Employee2> listemp1=new ArrayList<Employee2>();
	
	@DisplayName("Testing for save method")
	@Test
	public void saveEmployeeDetails() {
		Employee2 employee2=new Employee2(986,"Dharani","Pokuri",23,640);
		given(employee2Repository.save(employee2)).willReturn(employee2);
		String savedEmployeeDetails=employee2Service.saveEmployeeDetails(employee2);
	    assertThat(savedEmployeeDetails).isNotNull();
	}
    
	@DisplayName("Testing for save method exception")
	@Test
	public void saveEmployeeDetailsExc() {
		given(employee2Repository.save(employee2)).willReturn(employee2);
		org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, ()->
		employee2Service.saveEmployeeDetails(employee2));
	}
	@DisplayName("Testing for get method")
	@Test
	public void getEmployeeDetails() {
		Employee2 employee= new Employee2(986,"Dharani","Pokuri",31,765);
		Employee2 employee1=new Employee2(987,"Amisha","Shaik",22,560);
		Employee2 employee3=new Employee2(988,"Roshan","Shaik",11,260);
		given(employee2Repository.findAll()).willReturn(List.of(employee,employee1,employee3));
		List<Employee2> employeeList=employee2Service.getEmployeeDetails();
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(3);
	}
	
	@DisplayName("Testing for get method exception")
	@Test
	public void getEmployeeDetailsExc() {
		org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () ->{
			employee2Service.getEmployeeDetails();
		});
	}
	@DisplayName("Testing for sorting age method")
	@Test
	public void findAllOrderByAgeAsc() {
		Employee2 employee= new Employee2(986,"Dharani","Pokuri",31,765);
		Employee2 employee1=new Employee2(987,"Amisha","Shaik",22,560);
		Employee2 employee3=new Employee2(988,"Roshan","Shaik",11,260);
		listemp.add(employee);
		listemp.add(employee1);
		listemp.add(employee3);
		Mockito.when(employee2Repository.findAll()).thenReturn(listemp);
		listemp1=employee2Service.findAllOrderByAgeAsc();
		//assertEquals("James Johnson", lemp1.get(0).getFirstName()+" "+lemp1.get(0).getLastName());
		assertEquals(11,listemp1.get(0).getAge()); 
		//List<Employee2> employeeList=employee2Service.findAllOrderByAgeAsc();
		 //assertThat(employeeList).isNotNull();
		 //assertThat(employeeList.size()).isEqualTo(0);	
	}
	@DisplayName("Testing for sorting name method")
	@Test
	public void findAllOrderByNameAsc() {
		Employee2 employee= new Employee2(986,"Dharani","Pokuri",31,765);
		Employee2 employee1=new Employee2(987,"Amisha","Shaik",22,560);
		Employee2 employee3=new Employee2(988,"Roshan","Shaik",11,260);
		listemp.add(employee);
		listemp.add(employee1);
		listemp.add(employee3);
		Mockito.when(employee2Repository.findAll()).thenReturn(listemp);
		listemp1=employee2Service.findAllOrderByNameAsc();
		assertEquals("Amisha Shaik", listemp1.get(0).getFirstName()+" "+listemp1.get(0).getLastName());
		
	}


}
