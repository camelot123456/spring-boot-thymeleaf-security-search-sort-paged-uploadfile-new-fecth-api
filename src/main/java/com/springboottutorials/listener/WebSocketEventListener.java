package com.springboottutorials.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.springboottutorials.entity.ChatMessage;

@Component
public class WebSocketEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent connectedEvent) {
		LOGGER.info("Received a new web socket connection");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent disconnectEvent) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(disconnectEvent.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if (username != null) {
			LOGGER.info("User Disconnected: " + username);
			
			ChatMessage chatMessage = ChatMessage.builder()
					.type(ChatMessage.MessageType.LEAVE)
					.sender(username)
					.build();
			messagingTemplate.convertAndSend("/topic/publicChatRoom", chatMessage);
		}
	}
	
}
