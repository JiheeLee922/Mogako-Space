package com.mogako.mogakospace.chat.controller;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.mogako.mogakospace.chat.dto.ChatDTO;

import lombok.RequiredArgsConstructor;


/** StompChatController�� ���ϸ鼭 �����ϱ�!*/
@Controller
@RequiredArgsConstructor
public class StompRabbitController {
	
	private final RabbitTemplate template;  // ������ SimpleMessagingTemplate ����ߴ�.
	private final static String CHAT_EXCHANGE_NAME = "chat.exchange";
	private final static String CHAT_TOPIC = "amq.topic";
	private final static String CHAT_QUEUE_NAME = "chat.queue";
	private static final String ROUTING_KEY = "room.";
	
	
	@MessageMapping("chat.enter.{chatRoomId}")
	public void enter(ChatDTO chat, @DestinationVariable String chatRoomId) {
		//@DestinationVariable �� Web���� ����� �� @PathVariable�� ������. @MessageMapping�϶� �̰� ����.
		
		chat.setMessage("�����ϼ̽��ϴ�.");
		chat.setRegDate(LocalDateTime.now()); 
		
		template.convertAndSend(CHAT_TOPIC, ROUTING_KEY+ chatRoomId, chat); //Topic Destination
		//template.convertAndSend( ROUTING_KEY+ chatRoomId, chat); //Queue Destination
		//template.convertAndSend(CHAT_EXCHANGE_NAME, ROUTING_KEY+ chatRoomId, chat); //Exchange Destination
		
	}
	
	@MessageMapping("chat.message.{chatRoomId}")
	public void send(ChatDTO chat, @DestinationVariable String chatRoomId) {
		chat.setRegDate(LocalDateTime.now());
		
		template.convertAndSend(CHAT_TOPIC, ROUTING_KEY + chatRoomId, chat);
	}
	
	
	/** receive()�� �ܼ��� ť�� ���� �޼����� �Һ� �Ѵ�.( ����� �뵵)
	 * RabbitListener ������̼��� chat.queue ��� Queue�� ������ �� ť�� ���� �޼����� �Һ��ϴ� �Һ��ڰ� �ǰڴٴ� ������̼�.*/
	@RabbitListener(queues = CHAT_QUEUE_NAME)
	public void receive(ChatDTO chat) {
		System.out.println("received : "+chat.getMessage());
	}
	
}
