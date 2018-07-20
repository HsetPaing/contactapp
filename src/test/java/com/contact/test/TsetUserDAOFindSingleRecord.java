package com.contact.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.dao.UserDAO;
import com.contact.domain.User;

public class TsetUserDAOFindSingleRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);

		User u = userDAO.findById(1);
		// the user details will be take from delete user profile page
		System.out.println("-----USER DETAIL BY USERID----------");
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getEmail());
		System.out.println(u.getAddress());
		System.out.println(u.getLoginName());
		System.out.println(u.getRole());
		System.out.println(u.getLoginStatus());

	}

}
