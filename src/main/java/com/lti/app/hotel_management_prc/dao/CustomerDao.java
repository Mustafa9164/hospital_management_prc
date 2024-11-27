package com.lti.app.hotel_management_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.hotel_management_prc.entity.Customer;
import com.lti.app.hotel_management_prc.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo customerRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer getCustomerById(int id) {
		Optional<Customer> optional = customerRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Customer getCustomerByEmail(String email) {
		Customer customer = customerRepo.findByEmail(email);
		if(customer !=null) {
			return customer;
		}
		return null;
	}

	public Customer getCustomerByPhone(Long phone) {
		return customerRepo.findByPhone(phone);
	}

	public boolean deleteCustomerById(int id) {
		Optional<Customer> optional = customerRepo.findById(id);
		if(optional.isPresent()) {
			customerRepo.delete(optional.get());
			return true;
		}
		return false;
	}
}
