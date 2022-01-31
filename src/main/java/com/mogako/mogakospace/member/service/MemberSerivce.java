package com.mogako.mogakospace.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.mogako.mogakospace.member.domain.Role;
import com.mogako.mogakospace.member.domain.entity.MemberEntity;
import com.mogako.mogakospace.member.domain.repository.MemberRepository;
import com.mogako.mogakospace.member.dto.MemberDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberSerivce{
	
	private MemberRepository memberRepository;

	@Transactional
	public Long joinUser(MemberDto memberDto) {
		//��й�ȣ ��ȣȭ
		/*
		 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 * memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		 */
		
		return memberRepository.save(memberDto.toEntity()).getId();
	}
	
	
	
	public Map<String,String> validateHandling (Errors errors){
		Map<String,String> validatorResult = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		
		return validatorResult;
	}
	
	
}
