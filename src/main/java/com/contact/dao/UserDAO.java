package com.contact.dao;

import java.util.List;

import com.contact.domain.User;

public interface UserDAO {
	
	public void save(User u);
	
	public void update(User u);
	
	public void delete(User u);
	
	public void delete(int userId);
	
	public User findById(int userId);
	
	public List<User> findAll();
	
	public List<User> findbyProperty(String propName,Object propValue);
}
