package com.nana.spring.dao;

import java.util.List;

import com.nana.spring.model.Customer;

public interface CustomerDAO {

	public abstract List<Customer> list();
	public abstract Customer get(Integer id);
	public abstract Customer create(Customer customer);
	public abstract Customer delete(Integer id);
	public abstract Customer update(Customer customer);
	public abstract Customer findCustomer(Integer custId);
	
}