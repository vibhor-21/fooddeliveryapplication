package com.learning.fooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import com.learning.fooddeliveryapp.dto.Register;
import com.learning.fooddeliveryapp.exception.AlradyExistsException;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;

public interface UserService {

	public Register addUser(Register register) throws AlradyExistsException;
	public String updateUser(int id, Register register);
	public Register getUserById(int id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUsers();
	public String deleteUserById(int id) throws IdNotFoundException;
	public String authenticateUser(Register register);
}
