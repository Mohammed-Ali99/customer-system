package com.spring.customerapi.services;

import java.util.List;

import com.spring.customerapi.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public int deleteCustomer(int id);
	
}
