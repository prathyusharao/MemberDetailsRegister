package com.memberdetails.registers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.memberdetails.registers.model.MemberDetails;
import com.memberdetails.registers.repo.MemberDetailsRegisterRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberDetailsRegisterController {

	@Autowired
	MemberDetailsRegisterRepository customerRepository;

	@RequestMapping(method=RequestMethod.GET, value="/api/v1/employees")
	public List<MemberDetails> getAllCustomers() {
		return customerRepository.findAll();
	}

	 @RequestMapping(method=RequestMethod.POST, value="/api/v1/employees")
	public MemberDetails createCustomer(@RequestBody MemberDetails customer) {
		return customerRepository.save(customer);
	}

	 @PutMapping("/api/v1/employees/{id}")
	public ResponseEntity<MemberDetails> updateCustomer(@PathVariable("id") String id, @RequestBody MemberDetails customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		MemberDetails customerData = customerRepository.findOne(id);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerData.setName(customer.getName());
		customerData.setAddress(customer.getAddress());
		customerData.setState(customer.getState());
		customerData.setCountry(customer.getCountry());
		customerData.setPhoneno(customer.getPhoneno());
		customerData.setEmailid(customer.getEmailid());
		customerData.setPan(customer.getPan());
		MemberDetails updatedcustomer = customerRepository.save(customerData);
		return new ResponseEntity<>(updatedcustomer, HttpStatus.OK);
	}

	@DeleteMapping("/api/v1/employees/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		customerRepository.delete(id);
		
		return new ResponseEntity<>("Member has been deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping("/api/v1/employees/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		customerRepository.deleteAll();
		
		return new ResponseEntity<>("All Members have been deleted!", HttpStatus.OK);
	}
}
