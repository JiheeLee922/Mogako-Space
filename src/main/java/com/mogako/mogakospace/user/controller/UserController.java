package com.mogako.mogakospace.user.controller;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogako.mogakospace.user.domain.entity.UserMastEntity;
import com.mogako.mogakospace.user.domain.repository.UserMastRepository;
import com.mogako.mogakospace.user.domain.repository.UserMastRepositoryImpl;
import com.mogako.mogakospace.user.dto.UserMastDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	
	private UserMastRepositoryImpl userMastRepositoryImpl;
	private UserMastRepository userMastRepository;
	
	@PostMapping("/main/getMainInfo")
	public UserMastDTO getMainInfo(String email) {
		return userMastRepositoryImpl.findByEmailWithDsl(email);
	}
	
	@PostMapping("/user/postLogin")
	public UserMastDTO saveAboutMe(String email) {
		UserMastEntity a = userMastRepository.findByEmail(email);
		UserMastDTO dto = new UserMastDTO();
		BeanUtils.copyProperties(a, dto);
		
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(dto.getEmail().getBytes());
		
		String encodedEmail = new String(encodedBytes);
		dto.setEmail(encodedEmail);
		
		return dto;
	}
	
}
