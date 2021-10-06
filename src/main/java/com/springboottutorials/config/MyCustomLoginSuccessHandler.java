package com.springboottutorials.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.springboottutorials.constant.SystemConstant;
import com.springboottutorials.repository.IAccountRepository;

public class MyCustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Autowired
	private IAccountRepository accountRepository;
	
	public MyCustomLoginSuccessHandler(String defaultTaggetUrl) {
		// TODO Auto-generated constructor stub
		setDefaultTargetUrl(defaultTaggetUrl);
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.getSession().setAttribute(SystemConstant.ACCOUNT, accountRepository.findOneByUsername(authentication.getName()));
		if (session != null) {
			String redirectUrl = (String) session.getAttribute("redirectUrl");
			if (redirectUrl != null) {
				session.removeAttribute("redirectUrl");
				getRedirectStrategy().sendRedirect(request, response, redirectUrl);
			} else {
				super.onAuthenticationSuccess(request, response, authentication);
			}
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}
}
