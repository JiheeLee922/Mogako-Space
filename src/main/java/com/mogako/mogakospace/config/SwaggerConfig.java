package com.mogako.mogakospace.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private String version;
	private String title;
	
	@Bean
	public Docket apiV1() {
		version = "V1";
		title = "My closet API "+ version;
		
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder()
				.code(200)
				.message("OK!!")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(404)
				.message("Not Found!")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(500)
				.message("Internal Server Error!")
				.build());
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)		//false�� ������ swagger���� �������ִ� �����ڵ忡 ���� �⺻ �޽��� ����
				.groupName(version)					//Docket Bean�� �������� ��� groupname�� �浹���� �ʵ��� ��������
				.select()							//ApiSelectorBuilder ����
				.apis(RequestHandlerSelectors.basePackage("com.mogako.mogakospace.board.controller"))	//��Ʈ�ѷ��� �ۼ��Ǿ� �ִ� ��Ű�� ����.
				.paths(PathSelectors.ant("/board/**"))		//apis()���� ���õǾ��� API�� Ư�� path���ǿ� �´� API���� �ٽ� ���͸�
				.build()
				.apiInfo(apiInfo(title,version)) 		//���� ,���� �� ������ ���� �������� �����ֱ� ���� ȣ��
				.globalResponseMessage(RequestMethod.GET, responseMessages);
		
	}
	
	@Bean
	public Docket apiV2() {
		version = "V2";
		title = "My closet API "+ version;
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)		//false�� ������ swagger���� �������ִ� �����ڵ忡 ���� �⺻ �޽��� ����
				.groupName(version)					//Docket Bean�� �������� ��� groupname�� �浹���� �ʵ��� ��������
				.select()							//ApiSelectorBuilder ����
				.apis(RequestHandlerSelectors.basePackage("com.mogako.mogakospace.member.controller"))	//��Ʈ�ѷ��� �ۼ��Ǿ� �ִ� ��Ű�� ����.
				.paths(PathSelectors.ant("/**"))		//apis()���� ���õǾ��� API�� Ư�� path���ǿ� �´� API���� �ٽ� ���͸�
				.build()
				.apiInfo(apiInfo(title,version)); 		//���� ,���� �� ������ ���� �������� �����ֱ� ���� ȣ��
	}
	
	
	
	private ApiInfo apiInfo(String title, String version) {
		return new ApiInfo(
				title, 
				"Java Spring boot Jpa ������Ʈ",
				version,
				"www.example.com",
				new Contact("Contact Me", "www.example.com", "leejhdev922@gmail.com"), 
				"Licenses",
				"www.example.com",
				new ArrayList<>());
				
	}
	
	
	
	
}
