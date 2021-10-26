package com.springboottutorials.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

	@Transient
	public String getImagePath() {
		if (image == null) {
			return null;
		}
		return "/img/product/" + image;
	}

}
