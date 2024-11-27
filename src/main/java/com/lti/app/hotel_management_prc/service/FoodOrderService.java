package com.lti.app.hotel_management_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.app.hotel_management_prc.dao.FoodOrderDao;
import com.lti.app.hotel_management_prc.entity.FoodOrder;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@Service
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao foodOrderDao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		FoodOrder saveFoodOrder = foodOrderDao.saveFoodOrder(foodOrder);
		ResponseStructure<FoodOrder> structure=new ResponseStructure<FoodOrder>();

		if(saveFoodOrder !=null) {
			structure.setData(saveFoodOrder);
			structure.setMessage("food order saved");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.BAD_REQUEST);
	}

}
