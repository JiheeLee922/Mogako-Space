package com.mogako.mogakospace.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MvcConfiguration implements WebMvcConfigurer {

	
	@Bean
	public MessageSource messageSource() { //������ ���̸��� messageSource�����Ѵ�.
		
		//�޽��� ���Ϸ� ������Ƽ ���� ����� ���� MessageSource ����ü Ŭ����
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.messages");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	
//	@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver sessionLocalResolver = new SessionLocaleResolver();
//		sessionLocalResolver.setDefaultLocale(Locale.US);
//		
//		return sessionLocalResolver;
//	}
	
	
	
}
