package com.springboottutorials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboottutorials.entity.AccountEntity;
import com.springboottutorials.entity.enums.EAuthenticationProvider;
import com.springboottutorials.repository.IAccountRepository;
import com.springboottutorials.service.IAccountService;
import com.springboottutorials.utils.EncryptedPasswordUtil;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public void save(AccountEntity entity) {
		// TODO Auto-generated method stub
		entity.setAuthProvider(EAuthenticationProvider.LOCAL);
		entity.setId(generationCode(entity.getAuthProvider(), ""));
		entity.setPassword(EncryptedPasswordUtil.encryptedPassword(entity.getPassword()));
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
	public AccountEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findOneByUsername(username);
	}

	@Override
	public void saveOneNewAccountByOAuth(String id, String email, String name, String avatar,
			EAuthenticationProvider provider) {
		// TODO Auto-generated method stub
		AccountEntity account = new AccountEntity();
		account.setUsername(email);
		account.setFullname(name);
		account.setImage(avatar);
		account.setAuthProvider(provider);
		account.setId(generationCode(provider, id));
		accountRepository.save(account);
	}

	@Override
	public void updateOneNewAccountByOAuth(AccountEntity account, String email, String name, String avatar,
			EAuthenticationProvider provider) {
		// TODO Auto-generated method stub
		account.setFullname(name);
		account.setUsername(email);
		account.setImage(avatar);
		account.setAuthProvider(provider);
		accountRepository.save(account);
	}

	@Override
	public AccountEntity findOneById(String id) {
		// TODO Auto-generated method stub
		return accountRepository.findOneById(id);
	}

	public String generationCode(EAuthenticationProvider provider, String id) {
		if (provider.toString() != "LOCAL") {
			return provider.toString() + id;
		} else {
			return "LOCAL" + System.currentTimeMillis();
		}
	}

}
