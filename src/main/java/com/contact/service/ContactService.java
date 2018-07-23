package com.contact.service;

import java.util.List;

import com.contact.domain.Contact;

/**
 * The interface specifies all business operation for Contact Entity
 * @author HsetPaing
 *
 */
public interface ContactService {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(int contactId);
	public void delete(Integer[] contactIds);
	
	/**
	 * This method returns all User Contact (user who is logged in).
	 * @param userId
	 * @return
	 */
	public List<Contact> findUserContact(int userId);
	
	/**
	 * The method search contact for user(userId) based on given free-text-criteria (txt)
	 * @param userId User who is logged in
	 * @param txt criteria used to search - free text search criteria
	 * @return
	 */
	public List<Contact> findUserContact(int userId,String txt);

}
