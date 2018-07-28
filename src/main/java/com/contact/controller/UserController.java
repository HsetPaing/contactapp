package com.contact.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contact.common.LoginCommon;
import com.contact.domain.User;
import com.contact.execption.UserBlockedException;
import com.contact.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = {"/","index"})
	public String index(Model model) {
		model.addAttribute("command", new LoginCommon());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommon cmd, Model m, HttpSession session) {
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
