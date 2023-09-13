package com.wipro.accountTracker.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.wipro.accountTracker.models.Customer;
import com.wipro.accountTracker.repository.CustomerRepository;

class CustomerServiceTest {

	@InjectMocks
	CustomerService cService;

	@Mock
	CustomerRepository cRepository;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testGetCustomerByName() {

		List<Customer> clist = new ArrayList<>();

		Customer c = new Customer();

		c.setAccBal(80000);
		c.setAccNo(121212);
		c.setAccType("Saving");
		c.setBranch("MUMBAI");
		c.setCustomerName("Rohit");
		c.setIfscCode("COI");

		clist.add(c);

		when(cRepository.findBycustomerName("Rohit")).thenReturn(clist);

		clist = cService.findByName("Rohit");

		assertNotNull(clist);
		assertEquals(121212, clist.get(0).getAccNo());
	}
	
	@Test
	void testGetAllCustomer() {

		List<Customer> clist = new ArrayList<>();

		Customer c = new Customer();

		c.setAccBal(80000);
		c.setAccNo(121212);
		c.setAccType("Saving");
		c.setBranch("MUMBAI");
		c.setCustomerName("Rohit");
		c.setIfscCode("COI");
		
		Customer c1 = new Customer();

		c1.setAccBal(7000);
		c1.setAccNo(1323213);
		c1.setAccType("Current");
		c1.setBranch("PUNE");
		c1.setCustomerName("Mohit");
		c1.setIfscCode("SBI");

		clist.add(c);
		clist.add(c1);
		
		when(cRepository.findAll()).thenReturn(clist);

		clist = cService.getAll();

		assertNotNull(clist);
		assertEquals(2, clist.size());
	}
	
	
}
