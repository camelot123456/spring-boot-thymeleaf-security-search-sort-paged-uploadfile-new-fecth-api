package com.springboottutorials.service;

import java.util.List;

import com.springboottutorials.entity.AccountEntity;

public interface IAccountService {

	public List<AccountEntity> findAll();
	
	public void save(AccountEntity entity);
	
	public void update(AccountEntity entity);
	
	public void delete(String[] ids);

	public AccountEntity findOne(String username);
	
	
	
}
