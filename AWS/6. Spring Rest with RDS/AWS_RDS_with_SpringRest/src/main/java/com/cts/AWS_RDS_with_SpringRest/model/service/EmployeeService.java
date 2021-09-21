package com.cts.AWS_RDS_with_SpringRest.model.service;

import java.util.List;

import com.cts.AWS_RDS_with_SpringRest.model.Employee;


public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	String addEmployee(Employee employee);

}
