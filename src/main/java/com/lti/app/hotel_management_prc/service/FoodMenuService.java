package com.lti.app.hotel_management_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.app.hotel_management_prc.dao.FoodMenuDao;
import com.lti.app.hotel_management_prc.entity.FoodMenu;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@Service
public class FoodMenuService {
	
	@Autowired
	private FoodMenuDao foodMenuDao;

	public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodMenu(FoodMenu foodMenu) {
		 FoodMenu saveFoodMenu = foodMenuDao.saveFoodMenu(foodMenu);
		 ResponseStructure<FoodMenu> structure=new ResponseStructure<FoodMenu>();
		 
		 if(saveFoodMenu != null) {
			 structure.setData(saveFoodMenu);
			 structure.setMessage("Food menu saved");
			 structure.setStatusCode(HttpStatus.CREATED.value());
			 return new ResponseEntity<ResponseStructure<FoodMenu>>(structure,HttpStatus.CREATED);
		 }
		 return new ResponseEntity<ResponseStructure<FoodMenu>>(structure,HttpStatus.BAD_REQUEST);
	}

}
