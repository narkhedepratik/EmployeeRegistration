package com.empreg.app.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empreg.app.dao.DepartmentRepository;
import com.empreg.app.dao.EmployeeRepository;
import com.empreg.app.model.Department;
import com.empreg.app.model.Employee;
import com.empreg.app.service.EmployeeService;
@Service

public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    DepartmentRepository departmentRepositoy;
    @Autowired
    EmployeeRepository employeeRepository;
	@Override
	public List<Department> createDepartment(List<Department> deptList) {
      List<Department> savedDepartments=new ArrayList<>();
		deptList.stream().forEach(department->{
			
			savedDepartments.add(departmentRepositoy.save(department));
			
		});
		return savedDepartments;
	}
	@Override
	public Iterable<Department> getAllDepartments() {
		
		return departmentRepositoy.findAll();
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	@Override
	public Iterable<Employee> getAllEmployees() {
	
		Iterable<Employee> employeeList= employeeRepository.findAll();
	List<Employee> emps=(List<Employee>) employeeList;
	emps.stream().sorted((o1, o2) ->o1.getEmployeeId()-o2.getEmployeeId());
	return emps;
	}


}
