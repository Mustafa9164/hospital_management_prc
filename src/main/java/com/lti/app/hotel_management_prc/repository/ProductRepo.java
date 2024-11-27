package com.lti.app.hotel_management_prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.app.hotel_management_prc.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
