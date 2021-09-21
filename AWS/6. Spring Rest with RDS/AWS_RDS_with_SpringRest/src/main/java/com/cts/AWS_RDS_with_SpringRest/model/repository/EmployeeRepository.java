package com.cts.AWS_RDS_with_SpringRest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.AWS_RDS_with_SpringRest.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
