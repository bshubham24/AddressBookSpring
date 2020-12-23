package com.capgi.addressbookspring.dto;

import lombok.Data;

public @Data class AddressBookDTO {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;

	public AddressBookDTO(String firstName, String lastName, String address, String state, String city, String zip,
			String phoneNo, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setState(state);
		this.setCity(city);
		this.setZip(zip);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
	}

}
