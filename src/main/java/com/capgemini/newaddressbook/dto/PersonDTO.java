package com.capgemini.newaddressbook.dto;

public class PersonDTO {
	public int id;
	public String pName;
	public String pNo;
	public String address;
	public String city;
	public String zip;
	public String state;
	@Override
	public String toString() {
		return "PersonDTO [id="+id + ", pName=" + pName + ", pNo=" + pNo + ", address=" + address + ", city=" + city + ", zip=" + zip
				+ ", state=" + state + "]";
	}
	public PersonDTO(int id,String pName, String pNo, String address, String city, String zip, String state) {
		super();
		this.id = id;
		this.pName = pName;
		this.pNo = pNo;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
	};
	
}
