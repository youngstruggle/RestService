package com.nana.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nana.spring.model.Customer;
import com.nana.spring.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/* Get Customer */
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		System.out.println("----- Get Customer -----");
		return customerService.list();
	}

	/* Get Customer By Id */
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
		System.out.println("----- Get Customer By Id -----");
		Customer customer = customerService.get(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	/* Create Customer */
	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> createCustomer(
			@RequestBody Customer customer) {
		System.out.println("----- Create Customer -----");
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.EXPECTATION_FAILED);
		} else {
			customerService.create(customer);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	/* Delete Customer */
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
		System.out.println("----- Delete Customer -----");
		if (null == customerService.delete(id)) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	/* Update Customer */
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(
			@PathVariable("id") Integer custId, @RequestBody Customer customer) {
		System.out.println("----- Update Customer -----");
		Customer custUpdateById = customerService.findCustomer(custId);
		if (custUpdateById == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		custUpdateById.setFirstName(customer.getFirstName());
		custUpdateById.setLastName(customer.getLastName());
		custUpdateById.setEmail(customer.getEmail());
		custUpdateById.setMobile(customer.getMobile());
		customerService.update(custUpdateById);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
