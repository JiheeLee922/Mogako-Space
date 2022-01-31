package com.mogako.mogakospace.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.mogako.mogakospace.chat.dto.ChatMessageDTO;

import lombok.RequiredArgsConstructor;

/** �ش� ��Ʈ�ѷ��� stomp������ ���. rabbit ���� �Ŀ� StompRabbitController �����ϱ�!!!!!!*/
@Deprecated
@Controller
@RequiredArgsConstructor
public class StompChatController {

	private final SimpMessagingTemplate template ; //Ư�� Broker�� �޼����� ����
	
	
	//client�� SEND �� �� �ִ� ���
	//WebSocket Congig���� ������ setApplicationDestinationPrefixes �� ��� ���յ� -> "/pub/chat/enter"
	@MessageMapping(value="/chat/enter")	//�ش� ��븦 ���� WebSocket���� ������ �޼��� ���� ó��
	public void enter (ChatMessageDTO message) {
		message.setMessage(message.getWriter() + "���� ä�ù濡 �����Ͽ����ϴ�.");
		template.convertAndSend("/sub/chat/room/" + message.getRoomId() , message);
	}
	
	@MessageMapping(value = "/chat/message")
	public void message(ChatMessageDTO message) {
		template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
	}
	
	
}
