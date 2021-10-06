package com.springboottutorials.model;

import org.springframework.web.multipart.MultipartFile;

public class TestModel {

	private String name;
	private MultipartFile photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

}
