package com.lti.app.hotel_management_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.app.hotel_management_prc.dao.AdminDao;
import com.lti.app.hotel_management_prc.dao.CustomerDao;
import com.lti.app.hotel_management_prc.entity.Admin;
import com.lti.app.hotel_management_prc.entity.Customer;
import com.lti.app.hotel_management_prc.exception.IdNotFoundException;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		Admin saveAdmin = adminDao.saveAdmin(admin);
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		structure.setData(saveAdmin);
		structure.setMessage("admin saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Admin admin = adminDao.getAdminById(id);
		if(admin != null) {
			ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
			structure.setData(admin);
			structure.setMessage("success");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id Not Found "+id);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteAdmin(int id) {
		Admin admin = adminDao.getAdminById(id);
		ResponseStructure<Boolean> structure=new ResponseStructure<Boolean>();
		if(admin != null) {
			structure.setData(adminDao.deleteAdmin(id));
			structure.setMessage("Admin deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Boolean>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id Not Found "+id);	}

}
