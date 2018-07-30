package com.contact.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contact.common.LoginCommand;
import com.contact.common.UserCommand;
import com.contact.domain.User;
import com.contact.execption.UserBlockedException;
import com.contact.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = {"/","index"})
	public String index(Model model) {
		model.addAttribute("command", new LoginCommand());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if (loggedInUser == null) {
				// FAILD
				// add error message and go back to login-form
				m.addAttribute("err", "Login Failed! Enter valid credentials!");
				return "index";
			} else {
				// SUCCESS
				// check the role and redirect to a appropriate dashboard
				if (loggedInUser.getRole() == userService.ROLE_ADMIN) {
					// add admin detail in session (assign session to logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				} else if (loggedInUser.getRole() == userService.ROLE_USER) {
					// add user detail in session (assign session to logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				} else {
					m.addAttribute("err", "Invalid User ROLE");
					return "index";
				}
			}
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			// add error message and go back login-form
			m.addAttribute("err", e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "user/dashboard", method = RequestMethod.GET)
	public String userDashboard() {
		return "dashboard_user";
	}

	@RequestMapping(value = "admin/dashboard", method = RequestMethod.GET)
	public String adminDashboard() {
		return "dashboard_admin";
	}
	
	@RequestMapping(value="/reg_form")
	public String registrationForm(Model m) {
		//TODO command
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";
	}
	
	@RequestMapping(value="/register")
	public String register(@ModelAttribute("command") UserCommand cmd, Model m) {
		//TODO command
		User user = cmd.getUser();
		user.setRole(userService.ROLE_USER);
		user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
		userService.regiseter(user);		
		return "redirect:index?act=reg";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}

}
