package com.learning.fooddeliveryapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.fooddeliveryapp.dto.Register;
import com.learning.fooddeliveryapp.exception.AlradyExistsException;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;
import com.learning.fooddeliveryapp.service.UserService;

@RestController

@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlradyExistsException{
		
		Register result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUsersById(@PathVariable("userId") int id) throws IdNotFoundException{
		
		Register result = userService.getUserById(id);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		Optional<List<Register>> optional = userService.getAllUsers();
		
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			map.put("message", "no records found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") int id, @RequestBody Register register){
		
		return new ResponseEntity<>(userService.updateUser(id, register),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int id) throws IdNotFoundException{
		
		String result = userService.deleteUserById(id);
		
		if(result.equals("success")) {
			return new ResponseEntity<>(id, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("authenticate")
	public ResponseEntity<?> authenticateUser(Register register){
		String result = userService.authenticateUser(register);
		
		if(result.equals("success")) {
			return new ResponseEntity<>(register, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
