package com.nana.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.spring.dao.CustomerDAO;
import com.nana.spring.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> list() {
		return customerDAO.list();
	}

	@Override
	public Customer get(Integer id) {
		return customerDAO.get(id);
	}

	@Override
	public Customer create(Customer customer) {
		return customerDAO.create(customer);
	}

	@Override
	public Customer delete(Integer id) {
		return customerDAO.delete(id);
	}
	
	@Override
	public Customer update(Customer customer) {
		return customerDAO.update(customer);
	}
	
	@Override
	public Customer findCustomer(Integer custId){
		return customerDAO.findCustomer(custId);
	}

}
