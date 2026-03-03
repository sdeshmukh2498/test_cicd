package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.model.ResponseModel;
import com.example.demo.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/save")
	public ResponseModel save(@Valid @RequestBody LoginModel login) {

		String result = loginService.save(login);
	    return new ResponseModel(
	            200,
	            result,
	            null
	    );
	}
	
	@GetMapping("/authorize")
	public ResponseModel login(@Valid @RequestBody LoginModel login) {

		String result = loginService.authorize(login);
	    return new ResponseModel(
	            200,
	            result,
	            null
	    );
	} 
	@GetMapping("/getAll")
    public ResponseEntity<ResponseModel> fetchAllDetails() {
System.out.println("the api is triggered");
        List<LoginModel> result = loginService.fetchAllDetails();

        return ResponseEntity.ok(
                new ResponseModel(200, "Data fetched successfully", result)
        );
    }
	
}
