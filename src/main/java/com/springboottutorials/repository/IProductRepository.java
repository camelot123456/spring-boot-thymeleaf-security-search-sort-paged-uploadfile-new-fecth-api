package com.springboottutorials.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboottutorials.entity.ProductEntity;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<ProductEntity, String>{

	@Query("SELECT p FROM ProductEntity p WHERE CONCAT(p.price, '') LIKE %?1%"
			+ " OR p.name LIKE %?1%"
			+ " OR p.id LIKE %?1%")
	public Page<ProductEntity> search(String keyword, Pageable pageable);
	
}
