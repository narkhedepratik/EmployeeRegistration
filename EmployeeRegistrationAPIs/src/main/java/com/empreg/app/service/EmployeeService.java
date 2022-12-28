package com.empreg.app.service;

import java.util.List;

import com.empreg.app.model.Department;
import com.empreg.app.model.Employee;

public interface EmployeeService {

public	List<Department> createDepartment(List<Department> deptList);

public Employee saveEmployee(Employee employee);

public Iterable<Department> getAllDepartments();

public Iterable<Employee> getAllEmployees();



}
