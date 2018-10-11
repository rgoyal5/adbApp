package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.Contact;

public interface ContactService {

	Contact getContactById(long contactId);
	List<Contact> getAllContacts();
	Contact addContact(Contact contact);
	Contact updateContact(Contact contact);
	boolean deleteContact(long contactId);
	boolean existsByEmailId(String emailId);
	boolean existsByMobileNumber(String mobileNumber);
	
	Contact findByMobileNumber(String mobileNumber);
	Contact findByEmail(String emailId);
	List<Contact> findByLastName(String lastName);
	}
