package com.lti.app.hotel_management_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.hotel_management_prc.entity.Customer;
import com.lti.app.hotel_management_prc.service.CustomerService;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestParam int id, @RequestBody Customer customer){
		return customerService.saveCustomer(id,customer);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int id){
		return customerService.getCustomerById(id);
	}
	@GetMapping("/getByEmail")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(@RequestParam String email){
		return customerService.getCustomerByEmail(email);
	}
	@GetMapping("/getByPhone")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByPhone(@RequestParam Long phone){
		return customerService.getCustomerByPhone(phone);
	}
	@GetMapping("/delete")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int id){
		return customerService.deleteCustomerById(id);
	}
	
}
