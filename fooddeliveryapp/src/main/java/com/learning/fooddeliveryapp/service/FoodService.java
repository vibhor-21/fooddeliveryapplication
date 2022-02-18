 package com.learning.fooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import com.learning.fooddeliveryapp.dto.Food;
import com.learning.fooddeliveryapp.dto.FoodType;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;

public interface FoodService {

	public Food addFood(Food food);
	public Optional<List<Food>> getAllFood();
	public Food getFoodById(Long id);
	public String updateFood(Long id, Food food);
	public String deleteFoodById(Long id);
	public Optional<List<Food>> getAllfoodbytypes(FoodType foodType);
}
