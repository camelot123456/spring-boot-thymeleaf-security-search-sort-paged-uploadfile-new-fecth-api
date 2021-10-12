package com.springboottutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboottutorials.entity.AccountEntity;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, String>{

	public AccountEntity findOneByUsername(String username);
	
	public AccountEntity findOneById(String id);
}
