package com.cgi.EmployeeRESTApp.service;

import java.util.List;

import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDAlreadyPresentException;
import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDNotPresentException;
import com.cgi.EmployeeRESTApp.model.Employee;


public interface EmployeeService {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id) throws EmployeeWithTheIDNotPresentException;
	Employee addNewEmployee(Employee emp) throws EmployeeWithTheIDAlreadyPresentException;
	void deleteEmployee(int id) throws EmployeeWithTheIDNotPresentException;
	Employee updateEmployee(Employee emp) throws EmployeeWithTheIDNotPresentException;
	List<Employee> getEmployeesByDesignation(String designation);
	
}
