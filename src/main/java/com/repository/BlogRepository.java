package com.repository;

import com.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @（#）:BlogRepository
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
}
