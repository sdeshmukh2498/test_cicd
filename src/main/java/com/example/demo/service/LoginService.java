package com.example.demo.service;

import com.example.demo.model.LoginModel;

import jakarta.validation.Valid;

public interface LoginService {

	String save(@Valid LoginModel login);

	String authorize(@Valid LoginModel login);

}
