package com.springboottutorials.service;

import org.springframework.data.domain.Page;

import com.springboottutorials.entity.ProductEntity;

public interface IProductService {

	public Page<ProductEntity> findAll(int pageNumber, String sortField, String sortDir, String keyword);
	
	public ProductEntity findOne(String id);
	
	public ProductEntity save(ProductEntity entity);
	
	public ProductEntity update(ProductEntity entity);
	
	public void delete(String[] ids, String[] images, String uploadDir);
}
