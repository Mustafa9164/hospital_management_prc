package com.lti.app.hotel_management_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.hotel_management_prc.entity.Admin;
import com.lti.app.hotel_management_prc.repository.AdminRepo;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepo adminRepo;

	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public boolean deleteAdmin(int id) {
		Optional<Admin> optional = adminRepo.findById(id);
		if(optional.isPresent()) {
			adminRepo.delete(optional.get());
			return true;
		}
		return false;
	}
	
	

}
