package com.capgi.addressbookspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.exception.PersonNotFoundException;
import com.capgi.addressbookspring.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	AddressBookData addressBookData = null;
	List<AddressBookData> addressBook = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() throws PersonNotFoundException {
		if (addressBook.isEmpty()) {
			throw new PersonNotFoundException("address book is empty!");
		} else
			return addressBook;
	}

	@Override
	public AddressBookData getAddressBookDataById(long id) throws PersonNotFoundException {
		if (addressBook.size() != 0) {
			for (AddressBookData data : addressBook) {
				if (data.getId() == id) {
					addressBookData = data;
				}
			}
		} else {
			throw new PersonNotFoundException("Person with the given Id not found!");
		}
		return addressBookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		if (addressBook == null) {
			addressBookData = new AddressBookData(1, addressBookDTO);
		} else {
			addressBookData = new AddressBookData(addressBook.size() + 1, addressBookDTO);

		}
		addressBook.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(long id, AddressBookDTO addressBookDTO)
			throws PersonNotFoundException {
		addressBookData = getAddressBookDataById(id);
		if (addressBook.get((int) id) != null) {
			addressBookData.setFirstName(addressBookDTO.getFirstName());
			addressBookData.setLastName(addressBookDTO.getLastName());
			addressBookData.setAddress(addressBookDTO.getAddress());
			addressBookData.setCity(addressBookDTO.getCity());
			addressBookData.setState(addressBookDTO.getState());
			addressBookData.setPhoneNo(addressBookDTO.getPhoneNo());
			addressBookData.setEmail(addressBookDTO.getEmail());

			return addressBookData;
		} else
			throw new PersonNotFoundException("Person with given Id not found!");
	}

	@Override
	public void deleteAddressBookDataById(long id) throws PersonNotFoundException {
		if (addressBook.get((int) id) == null) {
			throw new PersonNotFoundException("Person with given Id not found!");
		} else
			addressBook.remove((int) id - 1);

	}
}
