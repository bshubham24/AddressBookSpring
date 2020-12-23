package com.capgi.addressbookspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	AddressBookData addressBookData = null;
	List<AddressBookData> addressBook = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBook;
	}

	@Override
	public AddressBookData getAddressBookDataById(long id) {
		if (addressBook.size() != 0) {
			for (AddressBookData data : addressBook) {
				if (data.getId() == id) {
					addressBookData = data;
				}
			}
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
	public AddressBookData updateAddressBookData(long id, AddressBookDTO addressBookDTO) {
		addressBookData = getAddressBookDataById(id);
		if (addressBook.get((int) id) != null) {
			addressBookData.setFirstName(addressBookDTO.getFirstName());
			addressBookData.setLastName(addressBookDTO.getLastName());
			addressBookData.setAddress(addressBookDTO.getAddress());
			addressBookData.setCity(addressBookDTO.getCity());
			addressBookData.setState(addressBookDTO.getState());
			addressBookData.setPhoneNo(addressBookDTO.getPhoneNo());
			addressBookData.setEmail(addressBookDTO.getEmail());
		}
		return addressBookData;
	}

	@Override
	public void deleteAddressBookDataById(long id) {
		addressBook.remove((int) id - 1);

	}

}
