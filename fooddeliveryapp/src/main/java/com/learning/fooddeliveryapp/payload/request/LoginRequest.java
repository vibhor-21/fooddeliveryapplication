package com.learning.fooddeliveryapp.payload.request;



import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	
	
	private String username;
	
	@NotBlank
	private String password;

}