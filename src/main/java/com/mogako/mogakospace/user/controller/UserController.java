package com.mogako.mogakospace.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogako.mogakospace.member.dto.MailDto;
import com.mogako.mogakospace.member.dto.MemberDto;
import com.mogako.mogakospace.member.service.MailService;
import com.mogako.mogakospace.member.service.MemberSerivce;
import com.mogako.mogakospace.user.dto.UserMastDTO;
import com.mogako.mogakospace.user.service.UserMastSerivce;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	private MemberSerivce memberService;
	private UserMastSerivce userMastService;
	
	@PostMapping("/main/getMainInfo")
	public UserMastDTO getMainInfo(String email) {
		return userMastService.getMainInfo(email);
	}
	
	
}
