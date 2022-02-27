package com.mogako.mogakospace.common.code;

import java.util.Arrays;

import com.mogako.mogakospace.common.CommonCodeType;

import lombok.Getter;

@Getter
public enum RewardStatus implements CommonCodeType{
	Good("Good","10"),
	VeryGood("Very Good","20"),
	Excellent("Excellent","30");
	
	private String fieldValue;
	private String fieldName;
	
	RewardStatus(String fieldName , String fieldValue) {
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}
	
}
