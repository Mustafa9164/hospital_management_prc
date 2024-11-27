package com.lti.app.hotel_management_prc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String type;
	private double cost;
	
	@ManyToOne
	@JoinColumn
	private FoodMenu foodMenu;

}
