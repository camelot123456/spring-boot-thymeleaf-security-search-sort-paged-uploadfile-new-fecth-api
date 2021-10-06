package com.springboottutorials.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboottutorials.constant.SystemConstant;
import com.springboottutorials.entity.ProductEntity;
import com.springboottutorials.repository.IProductRepository;
import com.springboottutorials.service.IProductService;
import com.springboottutorials.utils.PropertiesUtil;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	long count = 0;

	@Override
	public Page<ProductEntity> findAll(int pageNumber, String sortField, String sortDir, String keyword) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		PageRequest pageable = PageRequest.of(pageNumber - 1, 5, sort);
		if (keyword != null) {
			return productRepository.search(keyword, pageable);
		}
		return productRepository.findAll(pageable);
	}

	@Override
	public void save(ProductEntity entity) {
		// TODO Auto-generated method stub
		count = productRepository.count();
		if (productRepository.existsById(entity.getId())) {
			System.out.println("ERROR!!!");
		}else {
			productRepository.save(entity);
		}
		if (count != productRepository.count()) {
			SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.insert.success");
		} else {
			SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.insert.error");
		}
	}

	@Override
	public void update(ProductEntity entity) {
		// TODO Auto-generated method stub
		count = productRepository.count();
		if (productRepository.existsById(entity.getId())) {
			productRepository.save(entity);
			if (count == productRepository.count()) {
				SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.update.success");
			} else {
				SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.update.error");
			}
		} else {
			SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.update.error");
		}
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		count = productRepository.count();
		for (String id : ids) {
			productRepository.deleteById(id);
		}
		if (count != productRepository.count()) {
			SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.delete.success");
		} else {
			SystemConstant.MESSAGE_API = PropertiesUtil.getValue("message.api.delete.error");
		}
	}

	@Override
	public ProductEntity findOne(String id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
	}

}
