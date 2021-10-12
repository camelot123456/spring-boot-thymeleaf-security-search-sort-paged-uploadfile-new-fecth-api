package com.springboottutorials.service;

import org.springframework.data.domain.Page;

import com.springboottutorials.entity.ProductEntity;

public interface IProductService {

	public Page<ProductEntity> findAll(int pageNumber, String sortField, String sortDir, String keyword);
	
	public ProductEntity findOne(String id);
	
	public void save(ProductEntity entity);
	
	public void update(ProductEntity entity);
	
	public void delete(String[] ids, String[] images, String uploadDir);
}
