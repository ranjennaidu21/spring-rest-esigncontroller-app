package com.esigncontroller.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esigncontroller.rest.entity.Customer;
import com.esigncontroller.rest.error.exception.CustomerNotFoundException;
import com.esigncontroller.rest.repository.CustomerRepository;


//Take note we have added Spring Security to secure the REST Endpoint.
//So we need username and password to access the REST Endpoint.
/*
 Postman will prompt for new credentials for
each REST request.
1. Run your REST application.
2. In Postman access the REST endpoint: GET /api/customers
You will initial get a 401 error: Unauthorized
3. To resolve this, in Postman, click the "Authorization" section of the request.
4. In the "Type" drop-down list, select "Basic Auth"
//Based on the username , there have different role which have access to certain function
//refer to DemoSecurityConfig.java for that
5. Enter user id: john, password: test123
6. Using Postman send the request again
If the user is authenticated, then they'll get the results of REST request. If not, they'll
see a 401 error
*/

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// autowire the CustomerService
	@Autowired
	//private CustomerService customerService;
	private CustomerRepository customerRepository;
	
	//@RequestMapping( "/item" )
	@GetMapping("/item")
	public String getStockItem() {
		return "It's working...!";
	}
	
	// add mapping for GET /customers
	@GetMapping("/customers/")
	public List<Customer> getCustomers() {
		
		//return customerService.getCustomers();
		return (List<Customer>) customerRepository.findAll();
		
	}

	
	// add mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	//the pathvariable need to be same as variable name inside the bracket above
	public Optional<Customer> getCustomer(@PathVariable int customerId) {
		
		Optional<Customer> theCustomer = customerRepository.findById(customerId);
		//if customer id not found in database , return null
		//For null objects , jackson return empty body
		//we need to handle exeption for that
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	
	// add mapping for POST /customers  - add new customer
	//TO TEST: Use POSTMAN , choose POST , paste the/customers url , click body tab and raw box,
	//then select from dropdown JSON(application/json)
	
	//the add as following before send
/*	
 	{
		"firstName" : "Ranjen",
		"lastName" : "Naidu",
		"email" : "ranjennaidu@test.com"
	}
	*/
	@PostMapping("/customers")
	//now we can access the requestbody as POJO
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case the pass an id in JSON ... set id to 0
		//we use hibernate , using the method saveOrUpdate in DAO, so if it is set to 0
		//hibernate will take it as empty or null which 
		//this is force a save of new item ... instead of update
		
		theCustomer.setId(0);
		
		customerRepository.save(theCustomer);

		return theCustomer;
	}
	/*
	// add mapping for PUT /customers - update existing customer
	//TO TEST: Use POSTMAN , choose PUT , paste the/customers url , click body tab and raw box,
	//then select from dropdown JSON(application/json)
	
	//LET UPDATE ID NO 9 
	//the add as following before send
	
	{
	    "id": 9,
	    "firstName": "Kaala",
	    "lastName": "Karikalan",
	    "email": "k_kala@test.com"
	}
	*/
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomerById(@PathVariable int customerId) {
		
		//since customer id is set, DAO will update customer in the database
		//updating to do
		//To update firstname as "Kaala" and lastname as "Babu" for id 4
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer customerEntity = customer.get();
		customerEntity.setFirstName("Kaala");
		customerEntity.setLastName("Babu");
		logger.info("Updated for id {} -> {}", 
				customerId,customerRepository.save(customerEntity));
		
		return customerEntity;
		
	}
	
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	//TO TEST: Use POSTMAN , choose DELETE , paste the/customers/8 url to delete customer
	//id 8, click body tab and raw box,
	//then select from dropdown JSON(application/json)
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Optional<Customer> tempCustomer = customerRepository.findById(customerId);
		
		// throw exception if Customer is null
		
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
				
		customerRepository.deleteById(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	

	
		
	
}


















