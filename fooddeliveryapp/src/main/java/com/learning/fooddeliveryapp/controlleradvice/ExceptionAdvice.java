package com.learning.fooddeliveryapp.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learning.fooddeliveryapp.exception.AlradyExistsException;


@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AlradyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler(AlradyExistsException e) {
		
		HashMap<String,String> map = new HashMap<>();
		map.put("message", "records not found "+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(com.learning.fooddeliveryapp.exception.IdNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(com.learning.fooddeliveryapp.exception.IdNotFoundException e){
		HashMap<String,String> map = new HashMap<>();
		map.put("message", "records not found "+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
}
