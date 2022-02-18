package com.learning.fooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import com.learning.fooddeliveryapp.dto.User;
import com.learning.fooddeliveryapp.exception.AlradyExistsException;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;

public interface UserService {

	public User addUser(User user) throws AlradyExistsException;
	public User updateUser(Long id, User user) throws IdNotFoundException;
	public User getUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUsers();
	public String deleteUserById(Long id) throws IdNotFoundException;
	public String authenticateUser(User user);
}
