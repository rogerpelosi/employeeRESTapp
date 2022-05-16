package com.cgi.EmployeeRESTApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	private int accNo;
	private String bankName;
	private int balance;
	
	@OneToOne(mappedBy = "account") //don't want to insert employee via account, only account via employee
	private Employee employee;
	
	public Account(int accNo, String bankName, int balance) {
		super();
		this.accNo = accNo;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	public Account() {}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", bankName=" + bankName + ", balance=" + balance + "]";
	}

}
