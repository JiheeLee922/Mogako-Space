package com.mogako.mogakospace.user.domain.repository;

import com.mogako.mogakospace.user.dto.UserMastDTO;

public interface UserMastRepository  {

	UserMastDTO findByEmailWithDsl(String email);
}
