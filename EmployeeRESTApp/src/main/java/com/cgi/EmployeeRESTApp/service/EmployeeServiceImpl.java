package com.cgi.EmployeeRESTApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDAlreadyPresentException;
import com.cgi.EmployeeRESTApp.exceptions.EmployeeWithTheIDNotPresentException;
import com.cgi.EmployeeRESTApp.model.Employee;
import com.cgi.EmployeeRESTApp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo; 

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeWithTheIDNotPresentException {
		// TODO Auto-generated method stub
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} 
		throw new EmployeeWithTheIDNotPresentException();
	}

	@Override
	public Employee addNewEmployee(Employee emp) throws EmployeeWithTheIDAlreadyPresentException {
		// TODO Auto-generated method stub
		Optional<Employee> optional = empRepo.findById(emp.getId());
		if(optional.isEmpty()) {
			empRepo.save(emp);
			return emp;
		}
		throw new EmployeeWithTheIDAlreadyPresentException();
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeWithTheIDNotPresentException {
		// TODO Auto-generated method stub
		Optional<Employee> optional = empRepo.findById(id);
		if(optional.isPresent()) {
			empRepo.delete(optional.get());
		} else {
			throw new EmployeeWithTheIDNotPresentException();
		}
		
	}
		
	

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeWithTheIDNotPresentException {
		// TODO Auto-generated method stub
		Optional<Employee> optional = empRepo.findById(emp.getId());
		if(optional.isPresent()) {
			optional.get().setDesignation(emp.getDesignation());
			optional.get().setFirstName(emp.getFirstName());
			optional.get().setSalary(emp.getSalary());
			empRepo.save(optional.get());
			return optional.get();
		}
		throw new EmployeeWithTheIDNotPresentException();
	}

}
