package com.mogako.mogakospace.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.mogako.mogakospace.member.domain.repository.MemberRepository;
import com.mogako.mogakospace.member.dto.MemberDto;
import com.mogako.mogakospace.user.domain.entity.UserMastEntity;
import com.mogako.mogakospace.user.domain.repository.UserMastRepository;
import com.mogako.mogakospace.user.dto.UserMastDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserMastSerivce{
	
	private MemberRepository memberRepository;
	private UserMastRepository userMastRepository;

	@Transactional
	public Long joinUser(MemberDto memberDto) {
		//��й�ȣ ��ȣȭ
		/*
		 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 * memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		 */
		return memberRepository.save(memberDto.toEntity()).getId();
	}
	
	@Transactional
	public UserMastDTO getMainInfo(String email){
		
		UserMastEntity userEntity =  userMastRepository.findByEmail(email)
				.orElseThrow(() -> null );
		
		UserMastDTO dto = UserMastDTO.builder()
							.userSeq(userEntity.getUserSeq())
							.nickname(userEntity.getNickname())
							.githubId(userEntity.getGithubId())
							.email(userEntity.getEmail())
							.userName(userEntity.getUserName())
							.userJob(userEntity.getUserJobCd())
							.introduceContent(userEntity.getIntroduceContent())
							.introducePhrase(userEntity.getIntroducePhrase())
							.profileImgPath(userEntity.getProfileImgPath())
							.mobile(userEntity.getMobile())
							.regDate(userEntity.getRegDate())
							.updtDate(userEntity.getUpdtDate())
							.build();
		return dto;
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
