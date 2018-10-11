package com.nana.spring.service;

import java.util.List;

import com.nana.spring.model.Customer;

/**
 * @author Nana Febriana
 */

public interface CustomerService {

	public abstract List<Customer> list();
	public abstract Customer get(Integer id);
	public abstract Customer create(Customer customer);
	public abstract Customer delete(Integer id);
	public abstract Customer update(Customer customer);
	public abstract Customer findCustomer(Integer id);
	
}