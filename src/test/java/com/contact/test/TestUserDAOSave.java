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
		u.setName("Aung Kaung");
		u.setPhone("01231425");
		u.setEmail("Agkg@gmail.com");
		u.setAddress("Pyay");
		u.setLoginName("AgKg");
		u.setPassword("agkg");
		u.setRole(1);//Admin Role
		u.setLoginStatus(1);//Active
		
		userDAO.save(u);
		System.out.println("-----USER SAVE----------------");
	}

}
