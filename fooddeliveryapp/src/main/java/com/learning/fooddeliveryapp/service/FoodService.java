package com.learning.fooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import com.learning.fooddeliveryapp.dto.Food;
import com.learning.fooddeliveryapp.dto.FoodType;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;

public interface FoodService {

	public Food addFood(Food food);
	public Optional<List<Food>> getAllFood();
	public Food getFoodById(int id);
	public String updateFood(int id, Food food);
	public String deleteFoodById(int id);
//	public Optional<List<Food>> getFoodType(FoodType foodtype);
}
