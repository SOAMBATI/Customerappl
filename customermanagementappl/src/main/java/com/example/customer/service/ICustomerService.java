package com.example.customer.service;

import java.util.List;
import com.example.customer.dto.CustomerInputDto;
import com.example.customer.entity.Customer;


public interface ICustomerService {

//	abstract method to create a new customer based on the provided input data.
	public Customer createCustomers(CustomerInputDto data);
	public List<Customer> getAllCustomers();
	
//	abstract method to get the details of a customer based on the customer ID.
	public Customer getCustomers(Integer cusId);
    public Customer getCustomerById(Integer cusId);
	//public Customer deleteCustomerById(Long cusId);
    public Customer saveCustomer(Customer cust);
//	public Customer deleteById(Long cusId);
	public void deleteCustomer(Integer cusId);
	public Customer updateCustomerByCusId(Integer cusId, Customer updatedCustomer);
	
}
