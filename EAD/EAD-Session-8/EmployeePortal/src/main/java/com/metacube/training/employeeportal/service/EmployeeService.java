package com.metacube.training.employeeportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.employeeportal.model.Employee;


public interface EmployeeService {
	List<Employee> getAll();
	boolean updateEmployee(Employee employee);
	boolean createEmployee(Employee employee);
	boolean updateEmployeeStatus(String employeeCode,String status);
	Employee getEmployeeByEmployeeCode(String employeeCode);
	boolean deleteEmployeeByEmployeeCode(String employeeCode);
	List<Employee> selectEmployeeByName(String firstName);
	
}
