package com.bit.sts10;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoWebSocket extends TextWebSocketHandler {
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1] + " : " + session.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
		String msg = message.getPayload();
		System.out.println(msg);
		TextMessage text = new TextMessage("Server : " + msg);
		session.sendMessage(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
	}
}
