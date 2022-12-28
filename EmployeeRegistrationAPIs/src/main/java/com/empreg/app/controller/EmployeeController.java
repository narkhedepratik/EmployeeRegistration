package com.empreg.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empreg.app.model.Department;
import com.empreg.app.model.Employee;
import com.empreg.app.responce.BaseResponse;
import com.empreg.app.service.EmployeeService;
@CrossOrigin("*")
@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
   public ResponseEntity<List<Department>> saveDepartmentInfo() {
	   Department mngt=new Department(1, "Management");
	   Department hr=new Department(2, "HR");
	   Department dev=new Department(3, "Devlopment");
	   Department test=new Department(4, "Testing");
	   Department prod=new Department(5, "Production");
	   List<Department> deptList=Arrays.asList(mngt,hr,dev,test,prod);
	  return new ResponseEntity<List<Department>>(employeeService.createDepartment(deptList), HttpStatus.OK);
   }
	@GetMapping("/departments")
	public ResponseEntity<BaseResponse<Iterable<Department>>> departmentDetailsInfo()
	{
		BaseResponse<Iterable<Department>> baseResponse=new BaseResponse<>(200,"All department details !", employeeService.getAllDepartments());
		return new ResponseEntity<BaseResponse<Iterable<Department>>>(baseResponse,HttpStatus.OK);
	}
	@PostMapping("/employee")
	public  ResponseEntity<BaseResponse<Employee>> createEmployee(@RequestBody Employee employee)
	{
		BaseResponse<Employee> baseResponse= new BaseResponse<>
		(2001,"Employee saved !",employeeService.saveEmployee(employee));
		return new ResponseEntity<BaseResponse<Employee>>(baseResponse,HttpStatus.CREATED);
	}
	@GetMapping("/employees")
	public ResponseEntity<BaseResponse<Iterable<Employee>>> employeeDetailsInfo()
	{
		BaseResponse<Iterable<Employee>> baseResponse=new BaseResponse<>(200,"All employee details !", employeeService.getAllEmployees());
		return new ResponseEntity<BaseResponse<Iterable<Employee>>>(baseResponse, HttpStatus.OK);
	}
}
