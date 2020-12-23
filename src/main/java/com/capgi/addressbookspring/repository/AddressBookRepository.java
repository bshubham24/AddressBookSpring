package com.capgi.addressbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgi.addressbookspring.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Long> {

}
