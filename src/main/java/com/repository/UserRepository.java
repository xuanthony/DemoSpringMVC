package com.repository;

import com.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @（#）:UserRepository
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
