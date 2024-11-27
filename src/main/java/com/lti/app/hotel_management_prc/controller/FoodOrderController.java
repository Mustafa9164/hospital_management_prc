package com.lti.app.hotel_management_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.hotel_management_prc.entity.FoodOrder;
import com.lti.app.hotel_management_prc.service.FoodOrderService;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@RestController
@RequestMapping("/foodMenu")
public class FoodOrderController {
	
	@Autowired
	private FoodOrderService foodOrderService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder){
		return foodOrderService.saveFoodOrder(foodOrder);
	}


}
