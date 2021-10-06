package com.springboottutorials.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping(value = {"/error/401"})
	public String error401() {
		return "error/bodys/401";
	}
	
	@RequestMapping(value = {"/error/403"})
	public String error403() {
		return "error/bodys/401";
	}
	
	@RequestMapping(value = {"/error/404"})
	public String error404() {
		return "error/bodys/401";
	}
	
	@RequestMapping(value = {"/error/500"})
	public String error500() {
		return "error/bodys/500";
	}
}
