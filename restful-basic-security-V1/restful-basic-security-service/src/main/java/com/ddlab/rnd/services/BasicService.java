package com.ddlab.rnd.services;

import com.ddlab.rnd.entity.UserEntity;

/**
 * The Interface BasicService.
 * @author Debadatta Mishra
 */
public interface BasicService {
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	UserEntity getUserById(String id);
	
	//You can provide your own methods for the business logic.

}
