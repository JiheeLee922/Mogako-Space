package com.mogako.mogakospace.common.commonCode;


import java.util.EnumSet;

import io.netty.util.internal.StringUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * {@link CommonCodeType} enum을 String과 상호변환하는 유틸리티 클래스
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonEnumValueConvertUtils {

	public static <T extends Enum<T> & CommonCodeType> T ofDataCode(Class<T> enumClass,
																	String dbCode) throws Exception {
		if(StringUtil.isNullOrEmpty(dbCode)) {
			return null;
		}
		
		return EnumSet.allOf(enumClass).stream()
				.filter(v -> v.getFieldValue().equals(dbCode))
				.findAny() 
				.orElseThrow(() -> new Exception(String.format("enum = [%s], fieldValue = [%s] 가 존재하지 않습니다.",enumClass.getName(), dbCode)));
	}
	
	public static <T extends Enum<T> & CommonCodeType> String toDataCode(T enumValue) {
		if(enumValue == null) {
			return "";
		}
		return enumValue.getFieldValue();
	}
}
