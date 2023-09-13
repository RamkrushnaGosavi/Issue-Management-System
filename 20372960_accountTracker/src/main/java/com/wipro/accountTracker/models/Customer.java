package com.wipro.accountTracker.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Customer_Details")
public class Customer {

	
	@Id
	@Column(name = "Account_Number")
	private long accNo;
	
	@Column(name = "Customer_Name")
	private String customerName;

	@Column(name = "IFSC_Code")
	private String ifscCode;

	@Column(name = "Account_Type")
	private String accType;

	@Column
	private String branch;

	@Column(name = "Balance")
	private double accBal;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

}
