package com.contact.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.dao.UserDAO;
import com.contact.domain.User;

public class TsetUserDAOUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);

		// the user details will be take from update user profile page
		User u = new User();
		u.setName("Mg Mg Gyi");
		u.setPhone("01231425");
		u.setEmail("mgmggyi@gmail.com");
		u.setAddress("Pathein");
		u.setRole(1);//Admin Role
		u.setLoginStatus(1);//Active
		u.setUserId(3);		

		userDAO.update(u);
		System.out.println("-----USER UPDATE----------------");

	}

}
