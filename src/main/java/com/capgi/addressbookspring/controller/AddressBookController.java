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

@RestController
public class AddressBookController {
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("Id") long Id) {
		return new ResponseEntity<String>("Get Call Success for id: " + Id, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addto) {
		return new ResponseEntity<String>("Created Entry for: " + addto, HttpStatus.OK);
	}

	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateAddressBookData(@PathVariable("Id") long Id,
			@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated Entry for id: " + Id + " : " + addressBookDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("Id") long Id) {
		return new ResponseEntity<String>("Deleted Entry for Id: " + Id, HttpStatus.OK);
	}
}
