package com.mogako.mogakospace.user.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mogako.mogakospace.member.domain.entity.MemberEntity;
import com.mogako.mogakospace.user.domain.entity.UserMastEntity;

public interface UserMastRepository extends JpaRepository<UserMastEntity, Long> {

	Optional<UserMastEntity> findByEmail(String email);
}
