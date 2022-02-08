package com.learning.fooddeliveryapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.fooddeliveryapp.dto.Login;
import com.learning.fooddeliveryapp.repo.LoginRepository;
import com.learning.fooddeliveryapp.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		if(login2!=null)
			return "success";
		else
			return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		if(!this.loginRepository.existsById(userName))
			return "fail";
		this.loginRepository.deleteById(userName);
		return "success";
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		if(!this.loginRepository.existsById(userName))
			return "fail";
		Optional<Login> login = this.loginRepository.findById(userName);
		login.get().setPassword(password);
		return (this.loginRepository.save(login.get())!=null)?"success":"fail";
	}

}
