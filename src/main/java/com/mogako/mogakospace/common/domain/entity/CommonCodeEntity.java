package com.mogako.mogakospace.common.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "COMMON_CODE")
@ToString
public class CommonCodeEntity implements Serializable{


	@Id
	@Column(length = 100, nullable = false)
	private String cmGroupValue;

	@Id
	@JoinColumn(name = "fieldValue")
	private String fieldValue;
	
	@Column
	private String fieldName;
	
	@Column
	private LocalDateTime regDate;
	
	
	
	
}
