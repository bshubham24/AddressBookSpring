package com.capgi.addressbookspring.service;

import java.util.List;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.model.AddressBookData;

public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(long id);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(long id, AddressBookDTO addressBookDTO);

	void deleteAddressBookDataById(long id);
}
