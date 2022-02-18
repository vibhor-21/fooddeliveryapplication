package com.learning.fooddeliveryapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.fooddeliveryapp.dto.Food;
import com.learning.fooddeliveryapp.dto.FoodType;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> 
{

	boolean existsByFoodName(String foodName);

	Optional<List<Food>> findByFoodType(FoodType type);
	
}
