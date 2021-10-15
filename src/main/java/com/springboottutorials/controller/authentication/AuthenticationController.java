package com.springboottutorials.controller.authentication;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.springboottutorials.constant.SystemConstant;
import com.springboottutorials.entity.AccountEntity;
import com.springboottutorials.service.IAccountService;
import com.springboottutorials.utils.UploadFileUtil;

@Controller
public class AuthenticationController {

	public static final String PATH_SAVE_FILE = "src/main/resources/static/img/avatar/";
	
	@Autowired
	private IAccountService accountService;
	
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

	@RequestMapping(value = {"/handler_sign_in"}, method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String handlerSignIn(@RequestPart("account") AccountEntity account,
			@RequestPart("file") MultipartFile file, HttpServletResponse resp) throws IOException {
		account.setImage(file.getOriginalFilename());
		UploadFileUtil.saveFile(PATH_SAVE_FILE, file.getOriginalFilename(), file);
		accountService.save(account);
		
		return "redirect:/";
	}

}
