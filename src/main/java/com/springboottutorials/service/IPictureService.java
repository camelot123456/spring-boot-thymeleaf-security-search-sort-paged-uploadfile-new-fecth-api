package com.springboottutorials.service;

import java.util.List;

import com.springboottutorials.entity.PictureEntity;

public interface IPictureService {

	public List<PictureEntity> findAll();
	
	public void save(PictureEntity entity);
}
