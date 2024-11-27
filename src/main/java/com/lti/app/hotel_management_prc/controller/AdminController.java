package com.lti.app.hotel_management_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.hotel_management_prc.entity.Admin;
import com.lti.app.hotel_management_prc.service.AdminService;
import com.lti.app.hotel_management_prc.util.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@RequestParam int id){
		return adminService.getAdminById(id);
	}
	
	@DeleteMapping("/deleteadmin")
	public ResponseEntity<ResponseStructure<Boolean>> deleteAdminById(@RequestParam int id){
		return adminService.deleteAdmin(id);
	}

}
