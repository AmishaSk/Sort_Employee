package com.EmployeeProject2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeProject2.entity.Employee2;

@Repository
@EnableJpaRepositories
public interface Employee2Repository extends CrudRepository<Employee2, Long> {
   
}
