package com.lti.app.hotel_management_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.hotel_management_prc.entity.FoodOrder;
import com.lti.app.hotel_management_prc.repository.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo foodOrderRepo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}
}
