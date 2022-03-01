package com.mogako.mogakospace.common.commonCode.code;

import com.mogako.mogakospace.common.commonCode.CommonCodeType;

import lombok.Getter;

@Getter
public enum SkillCode implements CommonCodeType{
	JAVASCRIPT("Javascript","10"),
	TYPESCRIPT("Javascript","10");
	
	private String fieldName;
	private String fieldValue;
	
	SkillCode(String fieldName, String fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
