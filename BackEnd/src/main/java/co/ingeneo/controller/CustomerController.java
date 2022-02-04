package co.ingeneo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ingeneo.dao.CustomerDao;
import co.ingeneo.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDao customerDao;

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomers() {

		List<Customer> customer = new ArrayList<>();

		try {
			customerDao.findAll().forEach(customer::add);

			if (customer.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/")
	public ResponseEntity<Customer> createTutorial(@RequestBody Customer customer) {
		try {
			Customer newCustomer = customerDao
					.save(new Customer(customer.getUserName(), customer.getName(), customer.getPassword()));

			return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
