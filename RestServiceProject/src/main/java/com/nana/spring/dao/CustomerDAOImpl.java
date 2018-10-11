package com.nana.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nana.spring.model.Customer;
import com.nana.spring.util.HibernateUtil;

/**
 * @author Nana Febriana
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);

	/* Get Customer */
	@Override
	public List<Customer> list() {
		List<Customer> customerList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customerList = session.createCriteria(Customer.class).list();
			session.getTransaction().commit();
			LOGGER.debug("Get customer");

			return customerList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction Finish");
		}
		return null;
	}

	/* Get Customer By Id */
	@Override
	public Customer get(Integer id) {
		Customer customer = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customer = (Customer) session.get(Customer.class, id);
			session.getTransaction().commit();
			LOGGER.debug("Get customer By Id");

			return customer;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return null;
	}
	
	/* Create Customer */
	@Override
	public Customer create(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			LOGGER.debug("Data Saved");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return customer;
	}

	/* Delete Customer */
	@Override
	public Customer delete(Integer id) {
		Customer customer = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customer = (Customer) session.get(Customer.class, id);
			if (customer != null) {
				session.delete(customer);
				session.getTransaction().commit();
			}
			LOGGER.debug("Data sucessfully deleted!");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction selesai");
		}
		return customer;
	}

	/* Update Customer */
	@Override
	public Customer update(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(customer);
			session.getTransaction().commit();
			LOGGER.debug("Data Di Update");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return customer;
	}

	/* Find Customer By Id */
	@Override
	public Customer findCustomer(Integer custId) {
		Customer customer = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			customer = (Customer) session.get(Customer.class, custId);
			session.getTransaction().commit();
			LOGGER.debug("Data Di Update");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			LOGGER.error("Error Bung {}", e.getMessage());
		} finally {
			session.close();
			LOGGER.info("Transaction finish");
		}
		return customer;
	}

}