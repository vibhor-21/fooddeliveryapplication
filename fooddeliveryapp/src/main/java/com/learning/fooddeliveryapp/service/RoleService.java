package com.learning.fooddeliveryapp.service;


import com.learning.fooddeliveryapp.dto.Role;

public interface RoleService 
{
	public String addRole(Role role);
	public String deleteRole(int roleId);

}