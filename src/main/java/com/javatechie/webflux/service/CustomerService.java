package com.javatechie.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.webflux.dao.CustomerDao;
import com.javatechie.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> loadAllCustomers() {
		long start = System.currentTimeMillis();
		List<Customer> customers = customerDao.getCustomers();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time: " + (end - start));
		return customers;
	}
	
	public Flux<Customer> loadAllCustomersStream() {
		long start = System.currentTimeMillis();
		Flux<Customer> customers = customerDao.getCustomersStream();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time: " + (end - start));
		return customers;
	}
}
