package com.contact.dao;

import java.util.List;

import com.contact.domain.Contact;

public interface ContactDAO {
	
	public void save(Contact c);
	
	public void update(Contact c);
	
	public void delete(Contact c);
	
	public void delete(int contactId);
	
	public void findById(int contactId);
	
	public List<Contact> findAll(Contact u);
	
	public List<Contact> findbyPropertiy(String propName,Object proValue);

}
