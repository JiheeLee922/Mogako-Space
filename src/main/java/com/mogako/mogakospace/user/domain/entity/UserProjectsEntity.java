package com.mogako.mogakospace.user.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_PROJECTS")
@ToString
public class UserProjectsEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectSeq;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "userSeq") 
	@JsonBackReference
	private UserMastEntity userMast;

	@Column(length = 200, nullable = false)
	private String projectName;
	
	@Column(length = 500, nullable = true)
	private String introduceText;
	@Column(length = 100, nullable = true)
	private String numberParticipants;
	@Column(length = 200, nullable = true)
	private String projectContents1;
	@Column(length = 200, nullable = true)
	private String projectContents2;
	@Column(length = 200, nullable = true)
	private String projectContents3;
	@Column(length = 200, nullable = true)
	private String projectContents4;
	@Column(length = 200, nullable = true)
	private String projectContents5;
	@Column(length = 100, nullable = true)
	private String startDate;
	@Column(length = 100, nullable = true)
	private String endDate;
	@Column
	private LocalDateTime regDate;
	
	@OneToMany(mappedBy = "userProjectsMast", fetch = FetchType.LAZY)
	private Set<ProjectSkillMapEntity> projectSkillMap = new LinkedHashSet<>();
	
	
	
	
}
