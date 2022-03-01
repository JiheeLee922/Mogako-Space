package com.mogako.mogakospace.common.commonCode;


import javax.persistence.AttributeConverter;

import io.netty.util.internal.StringUtil;
import lombok.Getter;

@Getter
public class AbstractCommonEnumAttributeConverter<E extends Enum<E> & CommonCodeType> implements AttributeConverter<E, String> {

	/**
	 *  대상 Enum 클래스의 {@link Class} 객체
	 */
	private Class<E> targetEnumClass;
	
	/**
	 * <code>nullable = false</code> 이면, 변환할 값이 null로 들어왔을 떄 예외 발생.
	 * <code>nullable = true </code> 이면, 변환할 값이 null일 때, 예외없이 실행.
	 * 특히 fieldValue로 변환 시에는 빈 문자열("")로 변환한다.
	 */
	private boolean nullable;
	
	/**
	 * <code>nullable = false </code>일 때 출력할 오류 메시지에서 enum에 대한 설명을 위해 Enum의 설명적 이름을 받는다.
	 */
	private String enumName;
	
	
	public AbstractCommonEnumAttributeConverter(Class<E> targetEnumClass, boolean nullable, String enumName) {
		this.targetEnumClass = targetEnumClass;
		this.nullable = nullable;
		this.enumName = enumName;
	}
	
	
	@Override
	public String convertToDatabaseColumn(E attribute) {
		if(!nullable && attribute == null) {
			System.out.println(String.format("%s는 NULL로 저장할 수 없습니다.", enumName));
		}
		return CommonEnumValueConvertUtils.toDataCode(attribute); 
	}

	@Override
	public E convertToEntityAttribute(String dbData) {
		E returnEnum = null;
		try {
			if(!nullable && StringUtil.isNullOrEmpty(dbData)) {
				System.out.println(String.format("%s가 DB에 NULL 혹은 Empty로 저장되어 있습니다.", enumName));
			}
		
			returnEnum = CommonEnumValueConvertUtils.ofDataCode(targetEnumClass, dbData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnEnum;
	}

	

}
