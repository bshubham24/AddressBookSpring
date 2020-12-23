package com.capgi.addressbookspring.controller;

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
import com.capgi.addressbookspring.model.AddressBookData;

@RestController
public class AddressBookController {

	AddressBookData addressBookData = null;
	ResponseDTO responseDTO = null;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		addressBookData = new AddressBookData(1, new AddressBookDTO("Shubham", "Bhawsar", "chandni chowk", "U.P",
				"Delhi", "456321", "7896541233", "email"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("Id") long Id) {
		addressBookData = new AddressBookData(Id, new AddressBookDTO("Shubh", "Bhawsar", "chandni chowk", "U.P",
				"Delhi", "456321", "7896541233", "email"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id: " + Id, addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		addressBookData = new AddressBookData(2, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Entry for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("Id") long Id,
			@RequestBody AddressBookDTO addressBookDTO) {
		addressBookData = new AddressBookData(Id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Entry for id: " + Id, addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("Id") long Id) {
		ResponseDTO responseDTO = new ResponseDTO("Deleted Entry for Id: " + Id, Id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
