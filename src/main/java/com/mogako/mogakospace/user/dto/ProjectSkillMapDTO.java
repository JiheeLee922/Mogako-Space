package com.mogako.mogakospace.user.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSkillMapDTO {

	
	//private Long projectSeq;
	private String skillCd;
	private LocalDateTime regDate;
	
}

