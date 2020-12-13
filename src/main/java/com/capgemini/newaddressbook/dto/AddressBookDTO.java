package com.capgemini.newaddressbook.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBookDTO {
	public List<PersonDTO> personList = new ArrayList<>();
	@Override
	public String toString() {
		return "AddressBookDTO [personList=" + personList + "]";
	}
}	
