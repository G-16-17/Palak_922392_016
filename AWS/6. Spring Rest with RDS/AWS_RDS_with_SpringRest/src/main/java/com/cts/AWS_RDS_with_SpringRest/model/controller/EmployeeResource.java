package com.cts.AWS_RDS_with_SpringRest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.AWS_RDS_with_SpringRest.model.Employee;
import com.cts.AWS_RDS_with_SpringRest.model.service.EmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}


}
