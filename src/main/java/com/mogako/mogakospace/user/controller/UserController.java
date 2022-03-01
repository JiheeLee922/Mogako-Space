package com.mogako.mogakospace.user.controller;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mogako.mogakospace.common.Constants;
import com.mogako.mogakospace.common.DefaultResponse;
import com.mogako.mogakospace.common.StatusCode;
import com.mogako.mogakospace.user.domain.entity.UserMastEntity;
import com.mogako.mogakospace.user.domain.repository.UserMastRepository;
import com.mogako.mogakospace.user.domain.repository.UserMastRepositoryImpl;
import com.mogako.mogakospace.user.dto.UserMastDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(value="UserController")
public class UserController {

	
	private UserMastRepositoryImpl userMastRepositoryImpl;
	private UserMastRepository userMastRepository;
	
	@ApiOperation(value = "메인화면 데이터 조회")
	@GetMapping("/main/getMainInfo")
	public ResponseEntity<DefaultResponse> getMainInfo(String email) {
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(email);
		
		UserMastDTO user = userMastRepositoryImpl.findByEmailWithDsl(new String(decodedBytes));
		return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, Constants.HTTP_RETURN_SUCCESS, user), HttpStatus.OK);
	}
	
	@ApiOperation(value = "로그인 후 유니크 키값 조회")
	@PostMapping("/user/postLogin")
	public ResponseEntity<DefaultResponse> saveAboutMe(@RequestBody Map<String,Object> paramMap) {
		String email = paramMap.get("email").toString();
		UserMastEntity a = userMastRepository.findByEmail(email);
		UserMastDTO dto = new UserMastDTO();
		BeanUtils.copyProperties(a, dto);
		
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(dto.getEmail().getBytes());
		
		String encodedEmail = new String(encodedBytes);
		//dto.setEmail(encodedEmail);
		
		return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, Constants.HTTP_RETURN_SUCCESS, encodedEmail), HttpStatus.OK);
	}
	
}
