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
import com.mogako.mogakospace.common.commonCode.code.SkillCode;
import com.mogako.mogakospace.common.commonCode.code.SkillCodeConverter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "PROJECT_SKILL_MAP")
@ToString
public class ProjectSkillMapEntity implements Serializable{

	@Id
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "projectSeq") 
	@JsonBackReference
	private UserProjectsEntity userProjectsMast;

//	@Id
//	@Column(length = 100, nullable = false)
//	private String skillCd;
//	
	//@Id
	@Convert(converter = SkillCodeConverter.class)
	private SkillCode skillCd;
	
	@Column
	private LocalDateTime regDate;
	
	
	
	
}
