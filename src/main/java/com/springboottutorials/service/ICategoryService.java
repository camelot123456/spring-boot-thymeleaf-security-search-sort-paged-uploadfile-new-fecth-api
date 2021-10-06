package com.springboottutorials.service;

import java.util.List;

import com.springboottutorials.entity.CategoryEntity;

public interface ICategoryService {
	
	public List<CategoryEntity> findAll();
	
	public void save(CategoryEntity entity);
	
	public void update(CategoryEntity entity);
	
	public void delete(String[] ids);
	
}
