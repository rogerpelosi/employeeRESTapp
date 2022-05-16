package com.cgi.EmployeeRESTApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private int id;
	//@Column(nullable = false, unique = false)
	private String firstName;
	private String designation;
	private String salary;
	
	@ElementCollection //captures by adding new table
	private List<Integer> monthlyRatings;
	
	@OneToOne(cascade = CascadeType.ALL) //captures by adding foreign key column to Employee table
	private Account account;
	
//	@OneToMany
//	private List<Account> accounts;
	
	public Employee(int id, String firstName, String designation, String salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee(){}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getDesignation() {return designation;}
	public void setDesignation(String designation) {this.designation = designation;}

	public String getSalary() {return salary;}
	public void setSalary(String salary) {this.salary = salary;}

	public List<Integer> getMonthlyRatings() {return monthlyRatings;}
	public void setMonthlyRatings(List<Integer> monthlyRatings) {this.monthlyRatings = monthlyRatings;}

	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", designation=" + designation + ", salary=" + salary
				+ ", monthlyRatings=" + monthlyRatings + ", account=" + account + "]";
	}

}
