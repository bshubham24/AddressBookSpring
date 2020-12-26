package com.capgi.addressbookspring.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.exception.PersonNotFoundException;
import com.capgi.addressbookspring.model.AddressBookData;
import com.capgi.addressbookspring.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	AddressBookData addressBookData = null;

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public AddressBookData getAddressBookDataById(long id) throws PersonNotFoundException {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Person with given id is not present"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(addressBookDTO);
		addressBookRepository.save(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(long id, AddressBookDTO addressBookDTO)
			throws PersonNotFoundException {
		AddressBookData addressBookData = addressBookRepository.findById(id).get();
		if (addressBookData != null && addressBookData.getId() == id) {
			if (Objects.nonNull(addressBookDTO.getFullName())) {
				addressBookData.setFullName(addressBookDTO.getFullName());
			}
			if (Objects.nonNull(addressBookDTO.getAddress())) {
				addressBookData.setAddress(addressBookDTO.getAddress());
			}
			if (Objects.nonNull(addressBookDTO.getCity())) {
				addressBookData.setCity(addressBookDTO.getCity());
			}
			if (Objects.nonNull(addressBookDTO.getState())) {
				addressBookData.setState(addressBookDTO.getState());
			}
			if (Objects.nonNull(addressBookDTO.getZip())) {
				addressBookData.setZip(addressBookDTO.getZip());
			}
			if (Objects.nonNull(addressBookDTO.getPhoneNo())) {
				addressBookData.setPhoneNo(addressBookDTO.getPhoneNo());
			}
			addressBookRepository.save(addressBookData);
			return addressBookData;
		} else {
			throw new PersonNotFoundException("Person with given id is not present!");
		}
	}

	@Override
	public void deleteAddressBookDataById(long id) throws PersonNotFoundException {
		AddressBookData addressBookData = addressBookRepository.findById(id).get();
		if (addressBookData.getFullName() != null) {
			addressBookRepository.deleteById(id);
		} else {
			throw new PersonNotFoundException("Employee not found!!!");
		}
	}
}
