package com.springboottutorials.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtil {

	public static String encryptedPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	public static void main(String[] args) {
		String password = "1";
		String encryptedPassword = encryptedPassword(password);
		System.out.println("Password: "+encryptedPassword);
	}
	
}
