package com.cts.AWS_RDS_with_SpringRest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.AWS_RDS_with_SpringRest.model.Employee;
import com.cts.AWS_RDS_with_SpringRest.model.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRespository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	@Override
	public String addEmployee(Employee employee) {
		employeeRespository.save(employee);
		return "Employee with Id "+employee.getId()+" added successully";
	}

}
