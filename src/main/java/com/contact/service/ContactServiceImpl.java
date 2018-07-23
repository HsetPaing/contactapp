package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.dao.BaseDAO;
import com.contact.dao.ContactDAO;
import com.contact.domain.Contact;
import com.contact.rm.ContactRowMapper;
import com.contact.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.save(c);
		
	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.update(c);
		
	}

	@Override
	public void delete(int contactId) {
		// TODO Auto-generated method stub
		contactDAO.delete(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
		// TODO Auto-generated method stub
		String ids = StringUtil.toCommaSeparateString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(int userId) {
		// TODO Auto-generated method stub
		List<Contact> contact = contactDAO.findbyProperty("userId", userId);		
		return contact;
	}

	@Override
	public List<Contact> findUserContact(int userId, String txt) {
		// TODO Auto-generated method stub
		String sql = "SELECT userId,name,phone,email,address,remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		List<Contact> contact = getJdbcTemplate().query(sql, new ContactRowMapper(),userId,txt);
		return contact;
	}

}
