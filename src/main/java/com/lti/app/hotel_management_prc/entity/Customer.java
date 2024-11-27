package com.lti.app.hotel_management_prc.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private Long phone;

	@CreationTimestamp
	private LocalDate dob;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private FoodOrder foodOrder;
	
	

}
