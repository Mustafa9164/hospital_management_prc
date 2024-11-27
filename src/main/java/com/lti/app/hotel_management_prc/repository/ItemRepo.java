package com.lti.app.hotel_management_prc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.app.hotel_management_prc.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
