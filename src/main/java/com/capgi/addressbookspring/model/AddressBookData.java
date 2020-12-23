package com.capgi.addressbookspring.model;

import com.capgi.addressbookspring.dto.AddressBookDTO;

public class AddressBookData {
	private long id;
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phoneNo;
	public String email;

	public AddressBookData(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.firstName = addressBookDTO.getFirstName();
		this.lastName = addressBookDTO.getLastName();
		this.address = addressBookDTO.getAddress();
		this.state = addressBookDTO.getState();
		this.city = addressBookDTO.getCity();
		this.zip = addressBookDTO.getZip();
		this.phoneNo = addressBookDTO.getPhoneNo();
		this.email = addressBookDTO.getEmail();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
