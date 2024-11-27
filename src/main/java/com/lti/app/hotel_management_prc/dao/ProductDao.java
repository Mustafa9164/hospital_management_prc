package com.lti.app.hotel_management_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.hotel_management_prc.repository.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo productRepo;
	
	
}
