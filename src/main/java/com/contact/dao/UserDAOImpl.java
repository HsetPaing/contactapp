package com.contact.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.contact.domain.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `contactdb`.`user` (`name`, `phone`, `email`, `address`, `loginName`, `password`,`role`, `loginStatus`) "
				+ " VALUES (:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		int userId = kh.getKey().intValue();
		u.setUserId(userId);
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findById(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findbyPropertiy(String propName, Object proValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
