package com.capgi.addressbookspring.model;

import com.capgi.addressbookspring.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBookData {
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;

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

}
