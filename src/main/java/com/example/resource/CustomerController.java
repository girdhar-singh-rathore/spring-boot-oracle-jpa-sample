package com.example.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("customers")
	public List<Customer> getAllCustomer() {
		return customerService.listAll();
	}

	@PostMapping("customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.saveOrUpdate(customer);
	}

	@PutMapping("customers")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customerDetails) {
		Customer customer = customerService.getById(customerDetails.getId());
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		Customer updatedCustomer = customerService.saveOrUpdate(customerDetails);
		return ResponseEntity.ok(updatedCustomer);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") String id) {
		Customer customer = customerService.getById(id);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "id") String id) {
		Customer customer = customerService.getById(id);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		customerService.delete(id);
		return ResponseEntity.ok().build();
	}
}
