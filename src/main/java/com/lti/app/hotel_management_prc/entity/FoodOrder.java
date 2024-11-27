package com.lti.app.hotel_management_prc.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private double totalCost;

	@CreationTimestamp
	private LocalDateTime dateTime;
	
	@OneToOne
	@JoinColumn
	private Customer customer;
	
	@OneToMany(mappedBy = "foodOrder",cascade = CascadeType.ALL)
	private List<Item> items;

}
