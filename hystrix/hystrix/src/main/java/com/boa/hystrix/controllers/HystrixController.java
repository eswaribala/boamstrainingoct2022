package com.boa.hystrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.hystrix.handlers.CustomerHandler;

@RestController
public class HystrixController {

	@Autowired
	private CustomerHandler customerHandler;
	
	@GetMapping("/")
	public ResponseEntity<String> getIndivialCustomerResponse(){
		return this.customerHandler.requestHandler();
	}
}
