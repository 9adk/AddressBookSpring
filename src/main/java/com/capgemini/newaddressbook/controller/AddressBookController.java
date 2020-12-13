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
import com.capgemini.newaddressbook.dto.ResponseDTO;
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	AddressBookDTO addBook = new AddressBookDTO();
	List<PersonDTO> list = addBook.personList;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("id") int id) {
		ResponseDTO response = new ResponseDTO("The person data for id: "+id+"is",list.get(id-1));
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		ResponseDTO response = new ResponseDTO("The AddressBook contains",list);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> newAddressBook(@RequestBody PersonDTO person){
		list.add(person);
		ResponseDTO response = new ResponseDTO("Added the person in addressbook",person);
		
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable("id") int id,@RequestBody PersonDTO person){
		list.set(id, person);
		ResponseDTO response = new ResponseDTO("Updated the person data in addressbook",person);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookById(@PathVariable("id") int id){
		list.remove(id-1);
		ResponseDTO response = new ResponseDTO("Deleted the data of id: ",id);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}

}
