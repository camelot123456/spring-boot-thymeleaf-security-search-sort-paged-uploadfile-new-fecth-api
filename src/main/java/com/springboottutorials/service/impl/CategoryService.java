package com.springboottutorials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboottutorials.entity.CategoryEntity;
import com.springboottutorials.repository.ICategoryRepository;
import com.springboottutorials.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired private ICategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void save(CategoryEntity entity) {
		// TODO Auto-generated method stub
		categoryRepository.save(entity);
	}

	@Override
	public void update(CategoryEntity entity) {
		// TODO Auto-generated method stub
		if (categoryRepository.existsById(entity.getId())) {
			categoryRepository.save(entity);
		}
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		for (String id : ids) {
			categoryRepository.deleteById(id);
		}
	}
	
}
