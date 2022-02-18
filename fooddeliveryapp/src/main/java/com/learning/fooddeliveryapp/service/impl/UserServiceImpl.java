package com.learning.fooddeliveryapp.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.fooddeliveryapp.dto.Login;
import com.learning.fooddeliveryapp.dto.User;
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
	public User addUser(User user) throws AlradyExistsException {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail()))
			throw new AlradyExistsException("this record already exits");
		
		User register2 = userRepository.save(user);
		
		if(register2!=null) {
			Login login = new Login(register2.getEmail(),register2.getPassword());
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
	public User updateUser(Long id, User user) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(this.userRepository.existsById(id)==false)
			throw new IdNotFoundException("id not exists");
		
		return this.userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id not found");
		}
		else
			return optional.get();
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		User optional = this.getUserById(id);
		if(optional==null)
			return "fail";
		else {
			userRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public String authenticateUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail()) || userRepository.existsById(user.getId()))
			return "success";
		else
			return "fail";
	}

}
