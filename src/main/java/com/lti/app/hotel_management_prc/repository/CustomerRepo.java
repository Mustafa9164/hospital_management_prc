package com.lti.app.hotel_management_prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.app.hotel_management_prc.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);

	Customer findByPhone(Long phone);

}
