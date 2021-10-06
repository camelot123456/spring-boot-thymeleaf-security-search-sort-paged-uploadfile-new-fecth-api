package com.springboottutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboottutorials.entity.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, String>{

}
