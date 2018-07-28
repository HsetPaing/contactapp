package com.contact.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.contact.dao.BaseDAO;
import com.contact.dao.UserDAO;
import com.contact.domain.User;
import com.contact.execption.UserBlockedException;
import com.contact.rm.UserRowMapper;

/**
 * @author HsetPaing
 *
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

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
		String sql = "SELECT userId,name,phone,email,address,role,loginStatus,loginName "
				+ " FROM user WHERE loginName=:ln AND password=:pw";

		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if (user.getLoginStatus() == UserService.LOGIN_STATUS_BLOCKED) {
				throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
			} else {
				return user;
			}

		} catch (EmptyResultDataAccessException ex) {
			// TODO: handle exception
			return null;
		}

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
