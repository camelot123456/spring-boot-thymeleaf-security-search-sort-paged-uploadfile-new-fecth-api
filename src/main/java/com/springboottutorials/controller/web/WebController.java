package com.springboottutorials.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = { "/", "/home" })
	public String homePage() {
		return "website/bodys/home";
	}

}
