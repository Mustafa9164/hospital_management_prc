package com.lti.app.hotel_management_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.hotel_management_prc.entity.FoodMenu;
import com.lti.app.hotel_management_prc.service.FoodMenuService;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@RestController
public class FoodMenuController {
	
	@Autowired
	private FoodMenuService foodMenuService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(@RequestBody FoodMenu foodMenu){
		return foodMenuService.saveFoodMenu(foodMenu);
	}

}
