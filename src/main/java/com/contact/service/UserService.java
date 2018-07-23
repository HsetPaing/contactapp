package com.contact.service;

import java.util.List;

import com.contact.domain.User;
import com.contact.execption.UserBlockedException;

/**
 * @author HsetPaing
 *
 */
public interface UserService {

	public static final int LOGIN_STATUS_ACTIVE = 1;
	public static final int LOGIN_STATUS_BLOCKED = 2;
	
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_USER = 2;

	/**
	 * The method handle the user registration task.
	 * @param u the new user
	 */
	public void regiseter(User u);

	/**
	 * The method handle login operation(authentication) using given credentials, it
	 * returns User object when success and null when fails. when user account is
	 * blocked an exception will be thrown by this method.
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws com.contact.exception.UserBlockedException
	 *             when user account is block.
	 */
	public User login(String loginName, String password) throws UserBlockedException;

	/**
	 * Call this method to get list of registered users.
	 * 
	 * @return
	 */
	public List<User> getUserLogin();

	/**
	 * This method change the user login status for details passed as argument.
	 * 
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(int userId, int loginStatus);
}
