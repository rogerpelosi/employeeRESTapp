package com.cgi.EmployeeRESTApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDAlreadyPresentException;
import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDNotPresentException;
import com.cgi.EmployeeRESTApp.model.Employee;
import com.cgi.EmployeeRESTApp.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
 
//	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployeesHandler(){
		ResponseEntity<List<Employee>> respEntity;
		List<Employee> employees = employeeService.getAllEmployees();
		respEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		return respEntity;
	}
	
	@PostMapping(value = "/employees")
	public ResponseEntity<?> addEmployeeHandler(@RequestBody Employee employee){
		ResponseEntity<?> respEnt;
		try {
			Employee newEmp = employeeService.addNewEmployee(employee);
			respEnt = new ResponseEntity<Employee>(newEmp, HttpStatus.CREATED);

		} catch(EmployeeWithTheIDAlreadyPresentException e) {
			respEnt = new ResponseEntity<String>("Failed to create the employee: Duplicate Resource", HttpStatus.CONFLICT);
		}
		return respEnt;
	}
	
	@GetMapping(value = "/employees/{empId}")
	public ResponseEntity<?> getEmployeeByIdHandler(@PathVariable("empId") int id){
		ResponseEntity<?> respEnt;
		try {
			Employee emp = employeeService.getEmployeeById(id);
			respEnt = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch(EmployeeWithTheIDNotPresentException e) {
			respEnt = new ResponseEntity<String>("Failed to find the employee with that ID", HttpStatus.NOT_FOUND);
		}
		return respEnt; 
	}
	
	@PutMapping(value = "/employees/{empId}")
	public ResponseEntity<?> updateEmployeeHandler(@RequestBody Employee updatedEmp){
		ResponseEntity<?> respEnt;
		try {
			Employee emp = employeeService.updateEmployee(updatedEmp);
			respEnt = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch(EmployeeWithTheIDNotPresentException e) {
			respEnt = new ResponseEntity<String>("Failed to find the employee with that ID", HttpStatus.NOT_FOUND);
		}
		return respEnt;
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<String> deleteEmployeeHandler(@PathVariable("empId") int id){
//		delete employee if it is present
//		else return the error response based on the exception thrown
		ResponseEntity<String> respEnt;
		try {
			employeeService.deleteEmployee(id);
			respEnt = new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
			return respEnt;
		} catch(EmployeeWithTheIDNotPresentException e) {
			respEnt = new ResponseEntity<String>("Failed to find the employee with that ID", HttpStatus.NOT_FOUND);
		}
		return respEnt;
	}

	
}
