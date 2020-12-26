package com.capgi.addressbookspring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {
	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name Invalid")
	private String fullName;
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

	public AddressBookDTO(String fullName, String address, String state, String city, String zip, String phoneNo) {
		this.setFullName(fullName);
		this.setAddress(address);
		this.setState(state);
		this.setCity(city);
		this.setZip(zip);
		this.setPhoneNo(phoneNo);
	}

}
