package com.mogako.mogakospace.user.dto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectsDTO {

	
	private Long userSeq;
	private Long projectSeq;
	private String projectName;
	private String introduceText;
	private String additionalExplanation;
	private String projectContents1;
	private String projectContents2;
	private String projectContents3;
	private String projectContents4;
	private String projectContents5;
	private String startDate;
	private String endDate;
	private LocalDateTime regDate;
	private Set<ProjectSkillMapDTO> projectSkillMap = new LinkedHashSet<>();
	
}

