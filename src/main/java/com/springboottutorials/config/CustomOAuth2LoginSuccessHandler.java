package com.springboottutorials.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.springboottutorials.constant.SystemConstant;
import com.springboottutorials.entity.AccountEntity;
import com.springboottutorials.entity.enums.EAuthenticationProvider;
import com.springboottutorials.security.oauth.google.CustomOAuth2User;
import com.springboottutorials.service.IAccountService;

@Component
public class CustomOAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private IAccountService accountService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

		String email = oAuth2User.getEmail();
		String name = oAuth2User.getName();
		String avatar = oAuth2User.getAvatar();
		String id = oAuth2User.getId();
		EAuthenticationProvider authenticationProvider = oAuth2User.getAuthenticationProvider();

//		System.out.println("id: " + id);
//		System.out.println("name: " + name);
//		System.out.println("avatar: " + avatar);
//		System.out.println("email: " + email);
//		System.out.println("authenticationProvider: " + authenticationProvider);
		AccountEntity account = accountService.findOneById(authenticationProvider.toString() + id);
		
		request.getSession().setAttribute(SystemConstant.ACCOUNT, account);

		if (account == null) {
			accountService.saveOneNewAccountByOAuth(id, email, name, avatar, authenticationProvider);
		} else {
			accountService.updateOneNewAccountByOAuth(account, email, name, avatar, authenticationProvider);
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
