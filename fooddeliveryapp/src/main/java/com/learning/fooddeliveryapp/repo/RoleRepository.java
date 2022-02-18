package com.learning.fooddeliveryapp.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.fooddeliveryapp.dto.EROLE;
import com.learning.fooddeliveryapp.dto.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
	
  Optional<Role> findByRoleName(EROLE roleName); 
  
  
}