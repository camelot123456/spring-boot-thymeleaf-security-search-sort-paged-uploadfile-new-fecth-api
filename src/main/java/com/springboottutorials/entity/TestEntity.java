package com.springboottutorials.entity;

public class TestEntity {

	private String id;
	private String name;
	private Integer quantity;
	private Double price;
	private CategoryEntity category;
	private String image;
	private String description;

	public TestEntity(String id, String name, Integer quantity, Double price, CategoryEntity category, String image,
			String description) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.image = image;
		this.description = description;
	}

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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", category="
				+ category.getId() + ", image=" + image + ", description=" + description + "]";
	}

}
