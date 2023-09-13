package com.wipro.accountTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.accountTracker.models.Customer;
import com.wipro.accountTracker.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	//find All Customer
	public List<Customer> getAll()
	{
		
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		
		
		
		return customers;
	}
	
	//Add Customer
	public void addCustomer(Customer customer)
	{	
		customerRepository.save(customer);
	}
	
	//update Customer
	public Customer updateCustomer(long accNo , Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	//remove customer
	public void deleteCustomer(long accNo)
	{
		customerRepository.deleteById(accNo);
	}
	
	
	//delete All Customer
	public void deleteAllCustomer()
	{
		customerRepository.deleteAll();
	}
	
	//fundTransfer
	public String fundTransfer(Customer customer, long reciverAccNo, double fund) {
		
		if(customerRepository.findByaccNo(customer.getAccNo()).get(0).getAccBal() >= fund)
		{
			
			Customer sender =  customerRepository.findByaccNo(customer.getAccNo()).get(0);
			
			sender.setAccBal(sender.getAccBal() - fund);
			
			updateCustomer(customer.getAccNo(), sender);
			
			Customer reciver =  customerRepository.findByaccNo(reciverAccNo).get(0);
			
			reciver.setAccBal(reciver.getAccBal() + fund);
			
			updateCustomer(reciverAccNo, reciver);
			
			return "Transaction Successfull..";
		}
		else
		{
			return "Insufficient Fund..!!";
		}
	}
	
	//find By Name
	public List<Customer> findByName(String customerName)
	{
		return customerRepository.findBycustomerName(customerName);	
	}
	
	
	//find By account No
	public List<Customer> findByAccNo(long accNo)
	{
		return customerRepository.findByaccNo(accNo);
	}
	
	//find By account type
	public List<Customer> findByAccountType(String accType)
	{
		return customerRepository.findByaccType(accType);	
	}
	
	//find By BalenceGreater
	public List<Customer> findByBalGreater(double bal)
	{
		return customerRepository.findByaccBalGreaterThan(bal);	
	}
	
	//find By BalenceLesser
	public List<Customer> findByBalLessthan(double bal)
	{
		return customerRepository.findByaccBalLessThan(bal);	
	}
	
	//find By Branch
	public List<Customer> findByBranch(String branch)
	{
		return customerRepository.findBybranch(branch);	
	}
	
}
