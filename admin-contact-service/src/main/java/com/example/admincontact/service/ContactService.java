package com.example.admincontact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admincontact.model.Contact;
import com.example.admincontact.repositry.AdminContactRepository;





@Service
public class ContactService {

	@Autowired
	private AdminContactRepository contactrepository;
	

	public Contact addContact (Contact contact) {
		return contactrepository.save(contact);
	}

	public List<Contact> getContact() {
		List<Contact> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		return contactrepository.findById(id);
	}

	public void deleteContact(String id) {
		contactrepository.deleteById(id);
	}
	public List<Contact> getContacts(){
		return contactrepository.findAll();
		
	}


}

