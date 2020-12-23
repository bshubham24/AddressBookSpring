package com.capgi.addressbookspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AddressBookSpringApplication.class, args);
		log.info("AddressBook App Started in {} Environment", context.getEnvironment().getProperty("environment"));
	}

}
