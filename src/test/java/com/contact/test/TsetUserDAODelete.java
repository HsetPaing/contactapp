package com.contact.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.dao.UserDAO;
import com.contact.domain.User;

public class TsetUserDAODelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);

		// the user details will be take from delete user profile page
		userDAO.delete(2);
		System.out.println("-----USER DELETE----------");

	}

}
