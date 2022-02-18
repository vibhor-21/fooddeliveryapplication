package com.learning.fooddeliveryapp.payload.response;


import java.util.List;

public class JwtResponse
{
	  private String token; //nothing but a encrypted string which will help us to access the secure endpoints from the server.
	  private String type = "Bearer";
	  private Long id;
	  private String username;
	  private String email;
	  private List<String> roles;
	  private String address;

	  public JwtResponse(String accessToken, Long id, String username, String email, String address,List<String> roles) {
	    this.token = accessToken;
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.address = address;
	    this.roles = roles;
	  }

	  public String getAccessToken() { 
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }
	  
	  public String getAddress()
	  {
		  return address;
	  }

	  public void setAddress() {
	    this.address=address;
	  }
	  public List<String> getRoles() {
		    return roles;
	  }

}
