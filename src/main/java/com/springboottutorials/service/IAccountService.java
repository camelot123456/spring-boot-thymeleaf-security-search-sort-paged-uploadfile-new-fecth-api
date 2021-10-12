package com.springboottutorials.service;

import java.util.List;

import com.springboottutorials.entity.AccountEntity;
import com.springboottutorials.entity.enums.EAuthenticationProvider;

public interface IAccountService {

	public List<AccountEntity> findAll();
	
	public void save(AccountEntity entity);
	
	public void update(AccountEntity entity);
	
	public void delete(String[] ids);

	public AccountEntity findOneByUsername(String username);

	public void saveOneNewAccountByOAuth(String id, String email, String name, String avatar, EAuthenticationProvider provider);

	public void updateOneNewAccountByOAuth(AccountEntity account, String email, String name, String avatar, EAuthenticationProvider provider);
	
	public AccountEntity findOneById(String id);

}
