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
	private String fullName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;

	public AddressBookData() {

	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.fullName = addressBookDTO.getFullName();
		this.address = addressBookDTO.getAddress();
		this.state = addressBookDTO.getState();
		this.city = addressBookDTO.getCity();
		this.zip = addressBookDTO.getZip();
		this.phoneNo = addressBookDTO.getPhoneNo();
	}

}
