package com.example.customer.service;



import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.customer.dto.CustomerInputDto;
import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.repository.ICustomerRepository;

import jakarta.transaction.Transactional;




/** 
 * Service class implementing the ICustomerService interface to manage customer-related operations.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository cusRepo;
	
	
	
//	 Create a new customer based on the provided input data.
	@Override
	public Customer createCustomers(CustomerInputDto data) {
		
//		saving customer input dto values to entity Customer
		Customer newData = new Customer();
		newData.setFirstName(data.getFirstName());
		newData.setLastName(data.getLastName());
		newData.setAadharNo(data.getAadharNo());
		newData.setEmailId(data.getEmailId());		
		newData.setAge(data.getAge());

//		Save the customer entity
		Customer finalData = cusRepo.save(newData);
		

		
		 
//		display the stored data
		Customer displayData = new Customer();
		displayData.setCusID(finalData.getCusID());
	    displayData.setFirstName(finalData.getFirstName());
		displayData.setLastName(finalData.getLastName());
		displayData.setAadharNo(finalData.getAadharNo());
		displayData.setEmailId(finalData.getEmailId());
		displayData.setAge(finalData.getAge());

		return displayData;
	}
	@Override
	public List<Customer> getAllCustomers() {
	return cusRepo.findAll();
	}
	
//	display the details of customer based on customer ID
	@Override
	public Customer getCustomers(Integer cusId) {
		
//		Retrieve and display the details of the customer
		Optional<Customer> opt = cusRepo.findById(cusId);
		if (opt.isPresent()) {

			Customer finalData = opt.get();
			Customer displayData = new Customer();
			displayData.setCusID(cusId);
			displayData.setFirstName(finalData.getFirstName());
			displayData.setLastName(finalData.getLastName());
			displayData.setAadharNo(finalData.getAadharNo());
			displayData.setEmailId(finalData.getEmailId());
			displayData.setAge(finalData.getAge());
			;
		   
			return displayData;
			
		}else {
//			Handle case where the customer with the given ID does not exist
			throw new CustomerNotFoundException("customer id does not exist");
		}
		
	}
	/*@Override
	public Customer deleteCustomerById(Integer cusId) {
	 return cusRepo.deleteById(cusId);
	
	}*/
	{/* @Override
	public Customer updateCustomerByCusId(long cusId, Customer custDetails) {
		Optional<Customer> op = cusRepo.findById(cusId);
		Customer cust=null;
		if (op.isPresent()) {
			cust = op.get();
			cust.setFirstName(custDetails.getFirstName());
			cust.setLastName(custDetails.getLastName());
			cust.setAadharNo(custDetails.getAadharNo());
			cust.setAge(custDetails.getAge());
			cust.setEmailId(custDetails.getEmailId());
			cust.setMobNo(custDetails.getMobNo());
			cusRepo.save(cust);
		}
		else {
			// If given id doesn't match it will throw Customer not found exception
			throw new CustomerNotFoundException("Customer not found with given id: " + cusId);
		}
		
		
		return cust;
	}*/}
	@Override
	public Customer getCustomerById(Integer cusId) {
		// TODO Auto-generated method stub
		return cusRepo.findById(cusId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " +cusId));
	}
//	public Customer createEntity( Customer entity) {
//        // Here you can check if the database is online before saving
//        if (isDatabaseOnline()) {
//            return cusRepo.save(entity);
//        } else {
//            // Database is offline, return null or throw an exception
//            return null;
//        }
//    }

//    private boolean isDatabaseOnline() {
//        // Your logic to check if the database is online goes here
//        // You might ping the database server or check its status through some API
//        // For simplicity, we return true always in this example
//        return true;
//    }
	@Override
    public Customer updateCustomerByCusId(Integer cusId, Customer updatedCustomer) {
        Customer existingCustomer = cusRepo.findById(cusId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + cusId));

        // Update fields
        //existingCustomer.setFirstName(updatedCustomer.getFirstName());
        //existingCustomer.setLastName(updatedCustomer.getLastName());
        //existingCustomer.setAadharNo(updatedCustomer.getAadharNo());
        existingCustomer.setAge(updatedCustomer.getAge());
        existingCustomer.setEmailId(updatedCustomer.getEmailId());


        // Update other fields as needed

        return cusRepo.save(existingCustomer);
    }


   /* public boolean deleteCustomer(Integer cusId) {
        if (cusRepo.existsById(cusId)) {
            cusRepo.deleteById(cusId);
            return true;
        }
        return false;
    }*/
    /*public void deleteCustomer(Integer cusId) {
        cusRepo.deleteById(cusId);
    }*/
    @Override
    public void deleteCustomer(Integer cusId) {
//
    	System.out.println("delete service triggered");
//		Customer cust=findById(cusId);
        cusRepo.deleteById(cusId);
//        return cust;
//
    }
    @Override
    public Customer saveCustomer(Customer cust) {
        return  cusRepo.save(cust);
    }

}
	
	
	


