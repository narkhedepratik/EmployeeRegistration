package com.empreg.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.empreg.app.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	

}
