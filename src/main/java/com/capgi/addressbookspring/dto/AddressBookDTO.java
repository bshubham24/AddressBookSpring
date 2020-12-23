package com.capgi.addressbookspring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {
	@NotEmpty(message = "First Name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "First Name Invalid")
	private String firstName;
	@NotEmpty(message = "Last Name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "Last Name Invalid")
	private String lastName;
	@NotEmpty(message = "Address cannot be empty")
	private String address;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "Invalid city")
	private String city;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]+", message = "Invalid State")
	private String state;
	@Pattern(regexp = "^[1-9]{1}[0-9]{5}", message = "Invalid zip")
	private String zip;
	@Pattern(regexp = "[0-9]{2}[\\s][7-9]{1}[0-9]{9}", message = "Invalid phone number")
	private String phoneNo;
	@Pattern(regexp = "^[a-zA-Z0-9+_-]+([.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+)([.][a-z]+)?[.][a-z]{2,}$", message = "Invalid Email id")
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
