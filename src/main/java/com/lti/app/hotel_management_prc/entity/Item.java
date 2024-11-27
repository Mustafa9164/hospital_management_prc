package com.lti.app.hotel_management_prc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double cost;
	private String name;
	private int quantity;
	private String category;
	
	@ManyToOne
	@JoinColumn
	private FoodOrder foodOrder;
	
	@ManyToOne
	@JsonIgnore
	private FoodMenu foodMenu;
}
