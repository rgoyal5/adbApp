package com.verizon.adb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contactList")
	public ModelAndView handleContactList(){
		return new ModelAndView("clistPage","contacts",contactService.getAllContacts());
	}
}
