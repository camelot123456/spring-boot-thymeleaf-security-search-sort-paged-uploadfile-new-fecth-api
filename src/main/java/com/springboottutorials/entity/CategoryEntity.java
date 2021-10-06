package com.springboottutorials.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME", columnDefinition = "nvarchar(255) not null")
	private String name;

	@Column(name = "[IMAGE]", columnDefinition = "nvarchar(255) default N'https://friconix.com/jpg/fi-cnsuxl-question-mark.jpg'")
	private String image;

	@Column(name = "CODE", columnDefinition = "varchar(255) not null unique")
	private String code;

	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products = new ArrayList<>();

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}
