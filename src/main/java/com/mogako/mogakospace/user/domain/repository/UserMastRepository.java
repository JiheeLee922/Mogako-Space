package com.mogako.mogakospace.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mogako.mogakospace.user.domain.entity.UserMastEntity;
import com.mogako.mogakospace.user.dto.UserMastDTO;

public interface UserMastRepository extends JpaRepository<UserMastEntity,Long>{

	UserMastDTO findByEmailWithDsl(String email);
	
	long insertAboutMe(UserMastDTO dtl);
	
	UserMastEntity findByEmail(String email);
}
