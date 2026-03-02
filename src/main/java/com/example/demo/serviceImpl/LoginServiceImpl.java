package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginModel;
import com.example.demo.repo.LoginRepo;
import com.example.demo.service.LoginService;

import jakarta.validation.Valid;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepo repo;
	
	@Override
	public String save(@Valid LoginModel login) {
		String response ="success";
		try {
			repo.save(login);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			response ="fail";
		}
		return response;
	}

	 @Override
	    public String authorize(@Valid LoginModel login) {

	        Optional<LoginModel> user = repo.findByUsername(login.getUsername());

	        if(user.isPresent()) {

	            LoginModel existingUser = user.get();

	            if(existingUser.getPassword().equals(login.getPassword())) {
	                return "Login Successful";
	            } else {
	                return "Invalid Password";
	            }

	        } else {
	            return "User does not exist";
	        }
	    }

}
