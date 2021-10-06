package com.springboottutorials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboottutorials.entity.RoleEntity;
import com.springboottutorials.repository.IRoleRepository;
import com.springboottutorials.service.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired private IRoleRepository roleRepository;

	@Override
	public List<RoleEntity> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void save(RoleEntity entity) {
		// TODO Auto-generated method stub
		roleRepository.save(entity);
	}

	@Override
	public void update(RoleEntity entity) {
		// TODO Auto-generated method stub
		if (roleRepository.existsById(entity.getId())) {
			roleRepository.save(entity);
		}
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		for (String id : ids) {
			roleRepository.deleteById(id);
		}
	}
	
	
}
