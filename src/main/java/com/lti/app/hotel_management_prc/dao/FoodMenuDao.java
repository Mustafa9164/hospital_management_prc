package com.lti.app.hotel_management_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.hotel_management_prc.entity.FoodMenu;
import com.lti.app.hotel_management_prc.repository.FoodMenuRepo;

@Repository
public class FoodMenuDao {
	
	@Autowired
	private FoodMenuRepo foodMenuRepo;

	public FoodMenu saveFoodMenu(FoodMenu foodMenu) {
		return foodMenuRepo.save(foodMenu);
	}
	
	

}
