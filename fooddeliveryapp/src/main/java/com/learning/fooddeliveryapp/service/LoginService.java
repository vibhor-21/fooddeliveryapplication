package com.learning.fooddeliveryapp.service;

import com.learning.fooddeliveryapp.dto.Login;

public interface LoginService {

	public String addCredentials(Login login);
	public String deleteCredentials(String userName);
	public String changePassword(String userName,String password);
}
