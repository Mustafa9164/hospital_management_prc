package com.lti.app.hotel_management_prc.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	
	
	@OneToOne(mappedBy = "admin",cascade = CascadeType.ALL)
	private FoodMenu foodMenu;
	
	@OneToMany(mappedBy ="admin",cascade = CascadeType.ALL)
	private List<Customer> customers;

}
