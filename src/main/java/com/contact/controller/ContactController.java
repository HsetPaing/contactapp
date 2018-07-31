package com.contact.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contact.domain.Contact;
import com.contact.service.ContactService;

/**
 * @author HsetPaing
 *
 */

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "user/contact_form")
	public String contactForm(Model model) {

		Contact contact = new Contact();
		model.addAttribute("command", contact);
		return "contact_form";
	}

	@RequestMapping(value = "user/save_contact")
	public String save(@ModelAttribute("command") Contact contact, Model model, HttpSession session) {
		try {
			int userId = (int) session.getAttribute("userId");
			contact.setUserId(userId);// FK logged in userId
			contactService.save(contact);
			return "redirect:contact_list?act=sv";
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("err", "Failed to save contact");
			return "contact_form";
		}

	}
	
	@RequestMapping(value = "user/contact_list")
	public String contactList(Model model) {		
		return "contact_list";
	}
}
