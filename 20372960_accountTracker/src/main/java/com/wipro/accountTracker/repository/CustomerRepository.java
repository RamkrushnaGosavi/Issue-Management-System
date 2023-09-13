package com.wipro.accountTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.accountTracker.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , Long>{
	

	int i = 0;
	
	List<Customer> findByaccNo(long accNo); 
	
	List<Customer> findBybranch(String branch);
	
	List<Customer> findByaccBalGreaterThan(double bal);
	
	List<Customer> findByaccBalLessThan(double bal);
	
	List<Customer> findByaccType(String accType);
	
	List<Customer> findBycustomerName(String customerName);
}
