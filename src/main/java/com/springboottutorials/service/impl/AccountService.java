package com.springboottutorials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboottutorials.entity.AccountEntity;
import com.springboottutorials.repository.IAccountRepository;
import com.springboottutorials.service.IAccountService;

@Service
public class AccountService implements IAccountService{

	@Autowired private IAccountRepository accountRepository;

	@Override
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public void save(AccountEntity entity) {
		// TODO Auto-generated method stub
		accountRepository.save(entity);
	}

	@Override
	public void update(AccountEntity entity) {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(entity.getId())) {
			accountRepository.save(entity);
		}
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		for (String id : ids) {
			accountRepository.deleteById(id);
		}
	}

	@Override
	public AccountEntity findOne(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findOneByUsername(username);
	}
	
	
	
}
