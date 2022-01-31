package com.mogako.mogakospace.util;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/** �ش� ��Ʈ�ѷ��� STOMP ���� �� ������. Stomp ���� ������ �ڵ鷯�� ���� ���� ���������� Stomp ���� �Ŀ��� �ʿ� ������*/
@Deprecated
@Component
public class SocketTextHandler extends TextWebSocketHandler{

	HashMap<String, WebSocketSession> sessions = new HashMap<>();

	
	//client���� �޽����� ������ ���۵� �� ����Ǵ� �Լ�
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		
		sendMessage(new TextMessage(payload));
		
	}

	
	//���� ������ �� ���۵Ǵ� �Լ�
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessions.put(session.getId(), session);
		
		//sendMessage(new TextMessage(session.getId()+"���� �����̽��ϴ�. "));
	}
	
	
	//���� ���� �� ����Ǵ� �Լ�
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session.getId());
		//sendMessage(new TextMessage(session.getId()+"���� �����̽��ϴ�. "));
		
		super.afterConnectionClosed(session, status);
	}
	
	
	
	private void sendMessage(WebSocketMessage<?> message) {
		try {
			for(String key: sessions.keySet()) {
				WebSocketSession s = sessions.get(key);
				s.sendMessage(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
