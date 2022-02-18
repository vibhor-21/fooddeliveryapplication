package com.learning.fooddeliveryapp.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//hod the signup information
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

 

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
  
    @Size(max=100)
	@NotNull
	private String address;

 

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}