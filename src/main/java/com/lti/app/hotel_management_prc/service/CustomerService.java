package com.lti.app.hotel_management_prc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.app.hotel_management_prc.dao.AdminDao;
import com.lti.app.hotel_management_prc.dao.CustomerDao;
import com.lti.app.hotel_management_prc.entity.Admin;
import com.lti.app.hotel_management_prc.entity.Customer;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(int id, Customer customer) {
		Admin admin = adminDao.getAdminById(id);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();

		if(admin != null) {
			List<Customer> customers = admin.getCustomers();
			
			if(customers == null) {
				customers=new ArrayList<Customer>();
			}
			customers.add(customer);
			adminDao.saveAdmin(admin);
			admin.setCustomers(customers);
			structure.setData(customerDao.saveCustomer(customer));
			structure.setMessage("customer saved");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();

		if(customer !=null) {
			structure.setData(customer);
			structure.setMessage("sucess");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);	
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(String email) {
		Customer customerByEmail = customerDao.getCustomerByEmail(email);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		if(customerByEmail !=null) {
			structure.setData(customerByEmail);
			structure.setMessage("sucess");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);	
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerByPhone(Long phone) {
		Customer customerByPhone = customerDao.getCustomerByPhone(phone);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		if(customerByPhone !=null) {
			structure.setData(customerByPhone);
			structure.setMessage("sucess");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);	
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();

		if(customer !=null) {
			customerDao.deleteCustomerById(id);
			structure.setData(customer);
			structure.setMessage("deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);	
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);
	}

}
