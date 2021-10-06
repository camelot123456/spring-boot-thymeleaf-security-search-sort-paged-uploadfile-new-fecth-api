package com.springboottutorials.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "PICTURE")
public class PictureEntity {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME",
		columnDefinition = "nvarchar(255) not null unique")
	private String name;
	
	@Column(name = "PREFIX",
		columnDefinition = "nvarchar(512) not null")
	private String prefix;
	
	@Column(name = "SUFFIX",
		columnDefinition = "nvarchar(32) not null")
	private String suffix;
	
	@Column(name = "TYPE",
		columnDefinition = "nvarchar(32) not null")
	private String type;
	
	@Column(name = "SIZE",
		columnDefinition = "float default 0")
	private Double size;

//	private MultipartFile multipartFile;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}
//
//	public MultipartFile getMultipartFile() {
//		return multipartFile;
//	}
//
//	public void setMultipartFile(MultipartFile multipartFile) {
//		this.multipartFile = multipartFile;
//	} 
	
}
