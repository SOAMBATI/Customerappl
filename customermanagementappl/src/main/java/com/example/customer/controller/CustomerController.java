package com.example.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.CustomerInputDto;
import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.repository.ICustomerRepository;
import com.example.customer.service.CustomerServiceImpl;
import com.example.customer.service.ICustomerService;
import java.util.HashMap;


@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {

	@Autowired
	ICustomerService cusServ;
	
	@Autowired
	ICustomerRepository cusRepo;
	
	 /*@Autowired
	    public CustomerController(ICustomerService cusServ) {
	        this.cusServ = cusServ;
	    }*/
         
//	    End point to create new customers.
	    @PostMapping("/customer/create")
		ResponseEntity<Customer> createCustomer(@RequestBody CustomerInputDto data)
		{
//			Call the service to create a new customer
			Customer values = cusServ.createCustomers(data);
			return new ResponseEntity<>(values,HttpStatus.OK);
			
		};
		
		@GetMapping("/customer/data")
		public List<Customer> getAllCustomers() {
		return cusServ.getAllCustomers();
		}
		
//		display details of customer corresponding to customer id(cusId)
		/*@GetMapping("/customer/data/{cusId}")
		ResponseEntity<Customer> createCustomer(@PathVariable("cusId") Integer cusId)
		{
//			Call the service to retrieve customer details by ID
			Customer values = cusServ.getCustomers(cusId);
			return new ResponseEntity<>(values,HttpStatus.OK);
			
		};*/
		@GetMapping("/customer/data/{cusId}")  
		ResponseEntity<Customer> getCustomerById(@PathVariable("cusId") Integer cusId) {       
			// Call the service to retrieve customer details by ID
			Customer values = cusServ.getCustomers(cusId);       
			return new ResponseEntity<>(values, HttpStatus.OK);    
			}



	@PutMapping("/customer/update/{cusId}")
	public Customer updateCustomerByCusId(@PathVariable Integer cusId, @RequestBody Customer custDetails) {
		Customer customer = cusServ.getCustomerById(cusId);
		if (customer == null) {
			return null; // or ResponseEntity.notFound().build(); if you want to return a 404
		}
		customer.setFirstName(custDetails.getFirstName());
		customer.setLastName(custDetails.getLastName());
		customer.setAadharNo(custDetails.getAadharNo());
		customer.setAge(custDetails.getAge());
		customer.setEmailId(custDetails.getEmailId());

		// Assuming your cusServ implements ICustomerService
		// Save the updated customer using the service method
		return cusServ.saveCustomer(customer);
	}



	@DeleteMapping("/customer/delete/{cusId}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable Integer cusId) {
	        cusServ.deleteCustomer(cusId);
	        System.out.println("delete triggered");

	        ResponseEntity<String> resp=new ResponseEntity<>("Customer delted successfully", HttpStatus.OK);
	        return resp;
	    }
}
