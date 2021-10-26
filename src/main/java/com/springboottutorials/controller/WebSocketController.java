package com.springboottutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping(value = "/chat")
	public String chatShow() {
		return "messenger/bodys/chat";
	}
	
}
