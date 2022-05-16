package com.cgi.EmployeeRESTApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.EmployeeRESTApp.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

//	Define custom implementation in addition to extended JpaRepository ones
//	"Named Methods":
	List<Employee> findByDesignation(String designation);
	
//	'Hibernate' Mappings to associate classes corresponding to tables 
}
