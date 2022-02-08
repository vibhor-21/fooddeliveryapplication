package com.learning.fooddeliveryapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "food")

public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	
	@NotBlank
	private String foodName;
	
	@NotNull
	@Min(value = 0)
	private double foodCost;
	
	private FoodType foodtype;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String foodPic;
}
