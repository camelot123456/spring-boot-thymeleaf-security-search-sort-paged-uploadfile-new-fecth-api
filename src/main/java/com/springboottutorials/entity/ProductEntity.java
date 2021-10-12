package com.springboottutorials.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
	
	@Transient
	private String[] ids;
	
	@Transient
	private String[] images;
	
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME", columnDefinition = "nvarchar(255) default 'Name ' + cast(GETDATE() as nvarchar(32))")
	private String name;

	@Column(name = "[IMAGE]", columnDefinition = "nvarchar(255) default N'https://friconix.com/jpg/fi-cnsuxl-question-mark.jpg'")
	private String image;

	@Column(name = "QUANTITY", columnDefinition = "INT default 0")
	private Integer quantity;

	@Column(name = "PRICE", columnDefinition = "float default 0")
	private Double price;

	@Column(name = "[DESCRIPTION]", columnDefinition = "nvarchar(255) default 'Description ' + cast(GETDATE() as nvarchar(32))")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CATEGORY")
	private CategoryEntity category;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	@Transient
	public String getImagePath() {
		if (image == null) {
			return null;
		}
		return "/img/product/" + image;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}
}
