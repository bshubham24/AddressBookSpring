package com.capgi.addressbookspring.service;

import java.util.List;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.exception.PersonNotFoundException;
import com.capgi.addressbookspring.model.AddressBookData;

public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(long id) throws PersonNotFoundException;

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(long id, AddressBookDTO addressBookDTO) throws PersonNotFoundException;

	void deleteAddressBookDataById(long id) throws PersonNotFoundException;
}
