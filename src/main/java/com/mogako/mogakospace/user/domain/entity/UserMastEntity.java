package com.mogako.mogakospace.user.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_MAST")
@ToString
public class UserMastEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSeq;
	@Column(length = 100, nullable = false)
	private String nickname;
	@Column(length = 50, nullable = false)
	private String githubId;
	@Column(length = 50, nullable = true)
	private String email;
	@Column(length = 50, nullable = false)
	private String userName;
	@Column(length = 20, nullable = true)
	private String userJobCd;
	@Column(length = 200, nullable = true)
	private String introducePhrase;
	@Column(length = 500, nullable = true)
	private String introduceContent;
	@Column(length = 200, nullable = true)
	private String profileImgPath;
	@Column(length = 50, nullable = true)
	private String mobile;
	@Column
	private LocalDateTime regDate;
	@Column
	private LocalDateTime updtDate;
	
	@Builder
	public UserMastEntity(Long userSeq, String nickname, String githubId, String email, String userName,
			String userJobCd, String introducePhrase, String introduceContent, String profileImgPath, String mobile,
			LocalDateTime regDate, LocalDateTime updtDate) {
		super();
		this.userSeq = userSeq;
		this.nickname = nickname;
		this.githubId = githubId;
		this.email = email;
		this.userName = userName;
		this.userJobCd = userJobCd;
		this.introducePhrase = introducePhrase;
		this.introduceContent = introduceContent;
		this.profileImgPath = profileImgPath;
		this.mobile = mobile;
		this.regDate = regDate;
		this.updtDate = updtDate;
	}
	
}
