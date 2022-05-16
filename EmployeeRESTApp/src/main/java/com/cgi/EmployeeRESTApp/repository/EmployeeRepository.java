package com.cgi.EmployeeRESTApp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.EmployeeRESTApp.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
