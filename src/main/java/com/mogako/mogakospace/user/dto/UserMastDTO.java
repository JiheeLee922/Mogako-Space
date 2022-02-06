package com.mogako.mogakospace.user.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.mogako.mogakospace.member.domain.entity.MemberEntity;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserMastDTO {

	
	private Long userSeq;
	private String nickname;
	private String githubId;
	private String email;
	private String userName;
	private String userJob;
	private String introducePhrase;
	private String introduceContent;
	private String profileImgPath;
	private String mobile;
	private LocalDateTime regDate;
	private LocalDateTime updtDate;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.email(email)
				.nickname(nickname)
				.build();
	}
	
	
	
	@Builder
	public UserMastDTO(Long userSeq, String nickname, String githubId, String email, String userName, String userJob,
			String introducePhrase, String introduceContent, String profileImgPath, String mobile,
			LocalDateTime regDate, LocalDateTime updtDate) {
		this.userSeq = userSeq;
		this.nickname = nickname;
		this.githubId = githubId;
		this.email = email;
		this.userName = userName;
		this.userJob = userJob;
		this.introducePhrase = introducePhrase;
		this.introduceContent = introduceContent;
		this.profileImgPath = profileImgPath;
		this.mobile = mobile;
		this.regDate = regDate;
		this.updtDate = updtDate;
	}
	
	
}

