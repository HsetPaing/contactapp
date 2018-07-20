package com.contact.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.dao.UserDAO;
import com.contact.domain.User;

public class TsetUserDAOFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);

		List<User> users = userDAO.findAll();

		for (User u : users) {
			System.out.println("-----USER DETAIL FINDALL----------");
			System.out.println(u.getUserId() + " " + u.getName() + " "+ u.getRole() + " " + u.getLoginStatus());
			/*System.out.println(u.getName());
			System.out.println(u.getPhone());
			System.out.println(u.getEmail());
			System.out.println(u.getAddress());
			System.out.println(u.getLoginName());
			System.out.println(u.getRole());
			System.out.println(u.getLoginStatus());*/
		}

	}

}
