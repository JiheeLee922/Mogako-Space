package com.mogako.mogakospace.user.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mogako.mogakospace.common.code.RewardStatus;
import com.mogako.mogakospace.common.code.RewardStatusConverter;
import com.mogako.mogakospace.common.code.SkillCode;
import com.mogako.mogakospace.common.code.SkillCodeConverter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_REWARD_MAP")
@ToString
public class UserRewardMapEntity implements Serializable{

	@Id
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "userSeq") 
	@JsonBackReference
	private UserMastEntity userMast;

//	@Id
//	@Column(length = 100, nullable = false)
//	private String skillCd;
	
//	@Column(length = 50, nullable = false)
//	private String rewardStatusCd;

//	@Id
	@Convert(converter = SkillCodeConverter.class)
	private SkillCode skillCd;
	
	@Convert(converter = RewardStatusConverter.class)
	private RewardStatus rewardStatusCd;
	
	@Column
	private LocalDateTime regDate;
	
	
	
	
}
