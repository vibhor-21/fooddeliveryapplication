package com.learning.fooddeliveryapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.fooddeliveryapp.dto.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	Boolean existsByUserName(String userName);
}
