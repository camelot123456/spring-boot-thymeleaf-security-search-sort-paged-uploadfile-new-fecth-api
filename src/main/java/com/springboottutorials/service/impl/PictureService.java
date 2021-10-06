package com.springboottutorials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springboottutorials.entity.PictureEntity;
import com.springboottutorials.repository.IPictureRepository;
import com.springboottutorials.service.IPictureService;

@Service
public class PictureService implements IPictureService{

	@Autowired
	private IPictureRepository pictureRepository;
	
	@Override
	public List<PictureEntity> findAll() {
		// TODO Auto-generated method stub
		return pictureRepository.findAll();
	}

	@Override
	public void save(PictureEntity entity) {
		// TODO Auto-generated method stub
//		entity.setName(StringUtils.cleanPath(entity.getMultipartFile().getOriginalFilename()));
		
	}

}
