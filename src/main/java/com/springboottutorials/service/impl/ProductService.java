package com.springboottutorials.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboottutorials.entity.ProductEntity;
import com.springboottutorials.exception.ResourceNotFoundException;
import com.springboottutorials.repository.IProductRepository;
import com.springboottutorials.service.IProductService;
import com.springboottutorials.utils.UploadFileUtil;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

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
	public ProductEntity save(ProductEntity entity) {
		// TODO Auto-generated method stub
		if (!productRepository.existsById(entity.getId())) {
			return productRepository.save(entity);
		} else
			return null;

	}

	@Override
	public ProductEntity update(ProductEntity entity) {
		// TODO Auto-generated method stub
		if (productRepository.existsById(entity.getId())) {
			return productRepository.save(entity);
		} else
			return null;
	}

	@Override
	public void delete(String[] ids, String[] images, String uploadDir) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			UploadFileUtil.deleteFile(uploadDir, images[i]);
			productRepository.deleteById(ids[i]);
		}
	}

	@Override
	public ProductEntity findOne(String id) {
		// TODO Auto-generated method stub
//		Optional<ProductEntity> product = productRepository.findById(id);
//		if (product.isPresent()) {
//			return product.get();
//		} else {
//			throw new ResourceNotFoundException("Product", "Id", id);
//		}
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	}

}
