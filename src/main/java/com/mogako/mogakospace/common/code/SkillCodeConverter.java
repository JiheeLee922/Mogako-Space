package com.mogako.mogakospace.common.code;

import com.mogako.mogakospace.common.AbstractCommonEnumAttributeConverter;

public class SkillCodeConverter extends AbstractCommonEnumAttributeConverter<SkillCode>{

	public static final String ENUM_NAME = "기술코드";
	public SkillCodeConverter() { super(SkillCode.class,false, ENUM_NAME);}
}
