package com.springboottutorials.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ChatMessage {

	private MessageType type;
	private String content;
	private String sender;
	
	public enum MessageType{
		CHAT, JOIN, LEAVE
	}
	
}
