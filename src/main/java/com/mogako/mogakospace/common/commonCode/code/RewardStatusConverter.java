package com.mogako.mogakospace.common.commonCode.code;

import com.mogako.mogakospace.common.commonCode.AbstractCommonEnumAttributeConverter;

public class RewardStatusConverter extends AbstractCommonEnumAttributeConverter<RewardStatus>{

	public static final String ENUM_NAME = "리워드상태";
	
	public RewardStatusConverter() { super(RewardStatus.class, false, ENUM_NAME);}

}
