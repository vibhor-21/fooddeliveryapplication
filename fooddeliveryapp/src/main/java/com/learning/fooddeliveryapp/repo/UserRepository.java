package com.learning.fooddeliveryapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.fooddeliveryapp.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, Integer> {
	
	Boolean existsByEmail(String email);
}
