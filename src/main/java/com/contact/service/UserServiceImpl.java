package com.contact.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.dao.BaseDAO;
import com.contact.dao.UserDAO;
import com.contact.domain.User;
import com.contact.execption.UserBlockedException;
 
/**
 * @author HsetPaing
 *
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void regiseter(User u) {
		// TODO Auto-generated method stub
		userDAO.save(u);
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(int userId, int loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
