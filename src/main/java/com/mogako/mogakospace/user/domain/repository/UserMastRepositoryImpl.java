package com.mogako.mogakospace.user.domain.repository;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mogako.mogakospace.user.domain.entity.QProjectSkillMapEntity;
import com.mogako.mogakospace.user.domain.entity.QUserMastEntity;
import com.mogako.mogakospace.user.domain.entity.QUserProjectsEntity;
import com.mogako.mogakospace.user.domain.entity.QUserRewardMapEntity;
import com.mogako.mogakospace.user.domain.entity.UserMastEntity;
import com.mogako.mogakospace.user.dto.UserMastDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserMastRepositoryImpl extends QuerydslRepositorySupport {
	//private final JPAQueryFactory jpaQueryFactory;
	
	public UserMastRepositoryImpl() {
		super(UserMastEntity.class);
		
	}

	@Transactional
	public UserMastDTO findByEmailWithDsl(String email) 
	{
		ModelMapper modelMapper = new ModelMapper();
		
		QUserMastEntity userMast = QUserMastEntity.userMastEntity;
		QUserRewardMapEntity userRewardMap = QUserRewardMapEntity.userRewardMapEntity;
		QUserProjectsEntity userProjects = QUserProjectsEntity.userProjectsEntity;
		QProjectSkillMapEntity projectSkillMap = QProjectSkillMapEntity.projectSkillMapEntity;
		//QCommonCodeEntity commonCode = QCommonCodeEntity.commonCodeEntity;
		
		UserMastEntity result =  from(userMast)
								.leftJoin(userMast.userRewardMap, userRewardMap)
								.leftJoin(userMast.userProjects, userProjects)
								.innerJoin(userProjects.projectSkillMap, projectSkillMap)
		//						.innerJoin(userRewardMap.skillCd, commonCode)
								.where(userMast.email.eq(email)) 
								.fetchOne();
		
		UserMastDTO userDto =  modelMapper.map(result, UserMastDTO.class);
		
		return userDto;
	}

	@Transactional
	public long insertAboutMe(UserMastDTO dtl) {
		
		
		return 0;
	}



}
