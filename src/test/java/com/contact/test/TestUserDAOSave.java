package com.contact.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.dao.UserDAO;
import com.contact.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		
		//the user details will be take from user-reg-from
		User u = new User();
		u.setName("Mg Mg");
		u.setPhone("01231425");
		u.setEmail("mgmg@gmail.com");
		u.setAddress("Pathein");
		u.setLoginName("MgMg");
		u.setPassword("mgmg");
		u.setRole(1);
		u.setLoginStatus(1);
		
		userDAO.save(u);
		System.out.println("-----USER SAVE----------------");
	}

}
