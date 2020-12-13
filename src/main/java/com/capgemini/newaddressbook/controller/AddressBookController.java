package com.capgemini.newaddressbook.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.newaddressbook.dto.AddressBookDTO;
import com.capgemini.newaddressbook.dto.PersonDTO;
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	AddressBookDTO addBook = new AddressBookDTO();
	List<PersonDTO> list = addBook.personList;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAddressBookDataById(@PathVariable("id") int id) {
		return new ResponseEntity<String>("The person data for id: "+id+"is"+list.get(id-1),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("The AddressBook contains"+list,HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> newAddressBook(@RequestBody PersonDTO person){
		list.add(person);
		return new ResponseEntity<String>("Added the person in addressbook",HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAddressBook(@PathVariable("id") int id,@RequestBody PersonDTO person){
		list.set(id, person);
		return new ResponseEntity<String>("Updated the person data in addressbook",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddressBookById(@PathVariable("id") int id){
		list.remove(id-1);
		return new ResponseEntity<String>("Deleted the data of id: "+id+"from list is: "+list,HttpStatus.OK);
	}

}
