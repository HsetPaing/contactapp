package com.contact.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.contact.config.SpringRootConfig;
import com.contact.domain.User;
import com.contact.service.UserService;

/**
 * @author HsetPaing
 *
 */

public class TestUserServiceRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = context.getBean(UserService.class);

		// the user details will be take from user-reg-from
		User u = new User();
		u.setName("Yan Naing");
		u.setPhone("0987654321");
		u.setEmail("yannaing@gmail.com");
		u.setAddress("Yangon");
		u.setLoginName("yannaing");
		u.setPassword("yannaing");
		u.setRole(userService.ROLE_ADMIN);
		u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);

		userService.regiseter(u);
		System.out.println("-----USER Register Successfully----------------");
	}

}
