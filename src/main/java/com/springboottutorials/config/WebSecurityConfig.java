package com.springboottutorials.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.springboottutorials.security.oauth.google.CustomOAuth2UserService;
import com.springboottutorials.service.authorization.DetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DetailsService detailsService;
	
	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;
	
	@Autowired
	private CustomOAuth2LoginSuccessHandler customOAuth2LoginSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("camelot")
		.password("{noop}1").roles("ADMIN", "USER", "MANAGER");
		
		auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
	    InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
	    return memory;
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new MyCustomLoginSuccessHandler("/error/500");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		
		//no authentication
		http.authorizeRequests()
			.antMatchers("/", "/login", "/logout", "/register", "oauth2/**")
			.permitAll();

		//authorization
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.access("hasAnyRole('ROLE_ADMIN')");
		http.authorizeRequests()
			.antMatchers("/user/**")
			.access("hasAnyRole('ROLE_USER')");
		http.authorizeRequests()
			.antMatchers("/manager/**")
			.access("hasAnyRole('ROLE_MANAGER')");

		//authorizi exception
		http.authorizeRequests()
			.and().exceptionHandling().accessDeniedPage("/error/403");
		
		//authentication local
		http.authorizeRequests()
			.and().formLogin().loginPage("/login").usernameParameter("username")
			.passwordParameter("password").loginProcessingUrl("/handler_login_success")
			.successHandler(successHandler())
			.failureUrl("/login?error=true");
		
		//logout
		http.authorizeRequests()
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");
		http.authorizeRequests()
			.and().logout().deleteCookies("JSESSIONID", "remember-me");
		
		//authentication auth2
		http.authorizeRequests()
			.and().oauth2Login().loginPage("/login").userInfoEndpoint()
			.userService(customOAuth2UserService)
			.and().successHandler(customOAuth2LoginSuccessHandler);

		//remember me
		http.authorizeRequests()
			.and().rememberMe().rememberMeParameter("remember-me")
			.key("uniqueAndSecret").tokenRepository(this.persistentTokenRepository())
			.tokenValiditySeconds(24*60*60);
	}
	
}
