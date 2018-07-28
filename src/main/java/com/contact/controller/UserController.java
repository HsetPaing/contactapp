package com.contact.controller;

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

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("command", new LoginCommon());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommon cmd, Model m) {
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if (loggedInUser == null) {
				// FAILD
				// add error message and go back to login-form
				m.addAttribute("err", "Login Failed! Enter valid credentials!");
				return "index";
			} else {
				// SUCCESS
				//check the role and redirect to a appropriate dashboard
				if (loggedInUser.getRole() == userService.ROLE_ADMIN) {
					return "redirect:admin/dashboard";
				} else if (loggedInUser.getRole() == userService.ROLE_USER) {
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
}
