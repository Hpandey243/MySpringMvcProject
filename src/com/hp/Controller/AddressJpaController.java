package com.hp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.Entity.Address;
import com.hp.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/address")
public class AddressJpaController {
	@Autowired
	private EmployeeServiceImpl addressSrevice;
	
	@PostMapping("/saveAddress")
	public String saveAddress(@RequestBody Address address) {
	
		return addressSrevice.saveAddress(address);
	}
	

}
