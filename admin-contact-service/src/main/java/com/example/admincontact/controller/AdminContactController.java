package com.example.admincontact.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.admincontact.model.Contact;
import com.example.admincontact.repositry.AdminContactRepository;
import com.example.admincontact.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class AdminContactController {

	@Autowired
	private AdminContactRepository contactrepository;
	
	@Autowired
	private ContactService contactService;
	@PostMapping("/addContact")
	public String saveBook(@RequestBody Contact contact) {
	contactService.addContact(contact);
	return "Added contact with id :  " + contact.getId();
}
	
	@GetMapping("/findAllContacts")
	public List<Contact> getContacts(){
		return contactService.getContacts();
		
		
	}
	@GetMapping("/findAllContacts/{id}")
	public Optional<Contact> getContact(@PathVariable String id){
		return contactService.getContactbyId(id);
	}
	
	 @DeleteMapping("/delcontact/{id}")
		public String deleteContact (@PathVariable String id) {
		 
			contactService.deleteContact(id);
			return "Contact deleted with id : "+id;
		}
	}
