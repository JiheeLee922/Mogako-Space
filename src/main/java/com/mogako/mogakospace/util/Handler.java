package com.mogako.mogakospace.util;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * �Լ��� ȣ��Ǹ� Lambda�� �ڵ鷯 �޼��带 ����
 * */
public class Handler implements RequestHandler<Map<String, String>, String>{

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	/**
	 * �ڵ鷯 �޼ҵ�� �̺�Ʈ �� ���ؽ�Ʈ ��ü�� �Է����� �޾� ���ڿ��� ��ȯ.
	 * com.mogako.mogakospace.util.Handler::handle
	 * */
	@Override
	public String handleRequest(Map<String, String> event, Context context) {
		
		LambdaLogger logger = context.getLogger();
		String response = new String("200 OK");
		
		logger.log("ENVIRONMENT VARIABLES : " +gson.toJson(System.getenv()));
		logger.log("CONTEXT : "+ gson.toJson(context));
		
		logger.log("EVENT : "+ gson.toJson(event));
		logger.log("EVENT TYPE : "+ event.getClass().toString());
		
		return response;
	}
	

}
