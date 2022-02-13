package com.mogako.mogakospace.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogako.mogakospace.user.domain.repository.UserMastRepositoryImpl;
import com.mogako.mogakospace.user.dto.UserMastDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	
	private UserMastRepositoryImpl userMastRepositoryImpl;
	
	@PostMapping("/main/getMainInfo")
	public UserMastDTO getMainInfo(String email) {
		return userMastRepositoryImpl.findByEmailWithDsl(email);
	}
	
	
}
