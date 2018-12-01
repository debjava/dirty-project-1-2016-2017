package com.ddlab.rnd.services;

import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.UserEntity;

@Component("basicServiceImpl")
public class BasicServiceImpl implements BasicService {

	@Override
	public UserEntity getUserById(String id) {
		
		UserEntity entity = new UserEntity();
		entity.setFirstName("John");
		entity.setLastName("Abraham");
		entity.setId(id);
		
		return entity;
	}
	
	

}
