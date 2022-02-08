package com.learning.fooddeliveryapp.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.fooddeliveryapp.dto.Login;
import com.learning.fooddeliveryapp.dto.Register;
import com.learning.fooddeliveryapp.exception.AlradyExistsException;
import com.learning.fooddeliveryapp.exception.IdNotFoundException;
import com.learning.fooddeliveryapp.repo.LoginRepository;
import com.learning.fooddeliveryapp.repo.UserRepository;
import com.learning.fooddeliveryapp.service.LoginService;
import com.learning.fooddeliveryapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginService loginService;
	
	@Transactional
	
	@Override
	public Register addUser(Register register) throws AlradyExistsException {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(register.getEmail()))
			throw new AlradyExistsException("this record already exits");
		
		Register register2 = userRepository.save(register);
		
		if(register2!=null) {
			Login login = new Login(register2.getEmail(),register2.getPassword(),register2);
			//check
			if(loginRepository.existsByUserName(register2.getEmail())) {
				throw new AlradyExistsException("this record already exits");
			}
				
			String result = loginService.addCredentials(login);
			if(result.equals("success"))
				return register2;
			else
				return null;
			
		}
		else
			return null;
	}

	@Override
	public String updateUser(int id, Register register) {
		// TODO Auto-generated method stub
		if(this.userRepository.existsById(id)==false)
			return "fail";
		return (this.userRepository.save(register)!=null)?"success":"fail";
	}

	@Override
	public Register getUserById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id not found");
		}
		else
			return optional.get();
	}

	@Override
	public Optional<List<Register>> getAllUsers() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public String deleteUserById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register optional = this.getUserById(id);
		if(optional==null)
			return "fail";
		else {
			userRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public String authenticateUser(Register register) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(register.getEmail()) || userRepository.existsById(register.getRegId()))
			return "success";
		else
			return "fail";
	}

}
