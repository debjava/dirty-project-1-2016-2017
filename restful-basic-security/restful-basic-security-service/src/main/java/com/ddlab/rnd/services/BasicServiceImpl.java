package com.ddlab.rnd.services;

import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.UserEntity;

/**
 * The Class BasicServiceImpl.
 * @author Debadatta Mishra
 */
@Component("basicServiceImpl")
public class BasicServiceImpl implements BasicService {

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.services.BasicService#getUserById(java.lang.String)
	 */
	@Override
	public UserEntity getUserById(String id) {
		
		UserEntity entity = new UserEntity();
		entity.setFirstName("John");
		entity.setLastName("Abraham");
		entity.setId(id);
		
		return entity;
	}

}
