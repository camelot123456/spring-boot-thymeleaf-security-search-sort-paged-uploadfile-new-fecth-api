package com.springboottutorials.utils;

import java.util.ResourceBundle;

public class PropertiesUtil {
	public static final String PATH_PROPERTIES = "message-api";
	static ResourceBundle bundle = ResourceBundle.getBundle(PATH_PROPERTIES);
	
	public static final String getValue(String key) {
		return bundle.getString(key);
	}
	
}
