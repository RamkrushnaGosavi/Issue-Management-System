package com.wipro.accountTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.accountTracker.models.Customer;
import com.wipro.accountTracker.service.CustomerService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
public class MyController {
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String defaultMethod()
	{
		return "Hello World";
	}
	
	
	@GetMapping("/getAll")
	public List<Customer> findAll()
	{
		return customerService.getAll();
	}
	
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer)
	{
		customerService.addCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{accNo}")
	public void deleteCustomer(@PathVariable("accNo") long accNo)
	{
		customerService.deleteCustomer(accNo);
	}

	
	@DeleteMapping("/deleteAll")
	public void deleteAll()
	{
		customerService.deleteAllCustomer();
	}
	
	@PutMapping("/updateCustomer/{accNo}")
	public void updateCustomer(@PathVariable("accNo") long accNo , @RequestBody Customer customer)
	{
		customerService.updateCustomer(accNo, customer);
	}
	
	@PostMapping("/transferBal/{fund}/{reciverAccNo}")
	public String transferFund(@PathVariable("fund") double fund , @PathVariable("reciverAccNo") long reciverAccNo , @RequestBody Customer customer)
	{
		return customerService.fundTransfer(customer , reciverAccNo, fund);
	}
	
	
	
	//find By Name
	
	@ResponseBody
	@GetMapping("/findByName/{cName}")
	public List<Customer>findByName(@PathVariable("cName") String cName)
	{
		return  customerService.findByName(cName);	
	}
	
	//find By account type
	
	@ResponseBody
	@GetMapping("/findByAccountType/{accType}")
	public List<Customer> findByAccountType(@PathVariable("accType") String accType)
	{
		return customerService.findByAccountType(accType);	
	}
	
	//find By BalenceGreater
	
	@ResponseBody
	@GetMapping("/findByBalGreaterThan/{bal}")
	public List<Customer> findByBalGreater(@PathVariable("bal") double bal)
	{
		return customerService.findByBalGreater(bal);	
	}
	
	//find By BalenceLesser
	
	@ResponseBody
	@GetMapping("/findByBalLessThan/{bal}")
	public List<Customer> findByBalLessthan(@PathVariable("bal") double bal)
	{
		return customerService.findByBalLessthan(bal);	
	}
	
	//find By Branch
	
	@ResponseBody
	@GetMapping("/findByBranch/{branch}")
	public List<Customer> findByBranch(@PathVariable("branch") String branch)
	{
		return customerService.findByBranch(branch);	
	}
	
	
	//find By Account no
	
	@ResponseBody
	@GetMapping("/findByAccNo/{accNo}")
	public Customer findByAccNo(@PathVariable("accNo") long accNo)
	{
		return customerService.findByAccNo(accNo).get(0);
	}
	
}
