package com.spring.customerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customerapi.exception.CustomerException;
import com.spring.customerapi.model.Customer;
import com.spring.customerapi.model.CustomerError;
import com.spring.customerapi.services.CustomerService;


// http://localhost:8082/customer-api/
@RestController
@RequestMapping("/api")

//http://localhost:8082/customer-api/api

public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	// http://localhost:8082/customer-api/api/customers
	@GetMapping("/customers")
	public List<Customer> getData() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	} 
	
	// http://localhost:8082/customer-api/api/customers
	@PostMapping("customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	// http://localhost:8082/customer-api/api/customers/id
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		
		if(customer == null)
			throw new CustomerException("Customer Not Found id : " + id);
		return customer;
	}
	
	
	/*
	// http://localhost:8082/customer-api/api/customers?id=
	@GetMapping("/customers")
	public Customer getCustomer(@RequestParam("id") int id) {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
	*/
	
	
	// http://localhost:8082/customer-api/api/customers/id
	@DeleteMapping("/customers/{id}")
	public String removeCustomer(@PathVariable int id) {
		int res = customerService.deleteCustomer(id);
		if(res == 0)
			throw new CustomerException("Customer Not Found id : " + id);
		return "customer removed";
	}
	
	/*
	// http://localhost:8082/customer-api/api/customers?id=
	@DeleteMapping("/customers")
	public String removeCustomer(@RequestParam("id") int id) {
		customerService.deleteCustomer(id);
		return "customer removed";
	}
	*/
	
}
