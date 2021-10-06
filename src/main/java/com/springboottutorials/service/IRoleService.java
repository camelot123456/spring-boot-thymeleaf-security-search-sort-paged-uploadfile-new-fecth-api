package com.springboottutorials.service;

import java.util.List;

import com.springboottutorials.entity.RoleEntity;

public interface IRoleService {

	public List<RoleEntity> findAll();
	
	public void save(RoleEntity entity);
	
	public void update(RoleEntity entity);
	
	public void delete(String[] ids);
	
}
