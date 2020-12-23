package com.capgi.addressbookspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgi.addressbookspring.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name = "addressBook_data")
public @Data class AddressBookData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;

	public AddressBookData() {

	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
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
