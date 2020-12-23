package com.capgi.addressbookspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.addressbookspring.dto.AddressBookDTO;
import com.capgi.addressbookspring.dto.ResponseDTO;
import com.capgi.addressbookspring.exception.PersonNotFoundException;
import com.capgi.addressbookspring.model.AddressBookData;
import com.capgi.addressbookspring.service.IAddressBookService;

@RestController
public class AddressBookController {

	AddressBookData addressBookData = null;
	ResponseDTO responseDTO = null;

	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() throws PersonNotFoundException {
		List<AddressBookData> addressBook = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("Id") long Id) throws PersonNotFoundException {
		addressBookData = addressBookService.getAddressBookDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: " + Id, addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Entry for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("Id") long Id,
			@Valid @RequestBody AddressBookDTO addressBookDTO) throws PersonNotFoundException {
		addressBookData = addressBookService.updateAddressBookData(Id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Entry for id: " + Id, addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("Id") long Id)
			throws PersonNotFoundException {
		addressBookService.deleteAddressBookDataById(Id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Entry for Id: " + Id, Id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
