package com.mogako.mogakospace.user.dto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserMastDTO {

	
	private Long userSeq;
	private String nickname;
	private String email;
	private String userName;
	private String userJob;
	private String introducePhrase;
	private String introduceContent;
	private String profileImgPath;
	private String mobile;
	private LocalDateTime regDate;
	private LocalDateTime updtDate;
	private Set<UserRewardMapDTO> userRewardMap = new LinkedHashSet<>();
	private Set<UserProjectsDTO> userProjects  = new LinkedHashSet<>();

	
}

