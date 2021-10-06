package com.springboottutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboottutorials.entity.PictureEntity;

public interface IPictureRepository extends JpaRepository<PictureEntity, String>{

}
