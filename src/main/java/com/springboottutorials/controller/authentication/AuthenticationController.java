package com.springboottutorials.controller.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboottutorials.constant.SystemConstant;

@Controller
public class AuthenticationController {

	@RequestMapping(value = {"/login"})
	public String login(HttpServletRequest request, Model model) {
		String referrer = request.getHeader("Referer");
		if(referrer!=null){
	        request.getSession().setAttribute("redirectUrl", referrer);
	    }
		return "authentication/bodys/login";
	}
	
	@RequestMapping(value = {"/register"})
	public String register() {
		return "authentication/bodys/register";
	}
	
	@RequestMapping(value = {"/logout"})
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(SystemConstant.ACCOUNT);
		return "redirect:/";
	}

	
}
