package com.esigncontroller.rest.camel.services;

import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esigncontroller.rest.camel.responsebody.CustomerResponse;
import com.esigncontroller.rest.db.entity.Customer;
import com.esigncontroller.rest.db.error.exception.CustomerNotFoundException;
import com.esigncontroller.rest.db.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//SSL Enabled : access via: eg:https://localhost:8443/
	
@RestController
@RequestMapping("/customer")
public class CustomerRestService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    @GetMapping("/test")
    public String getCustomerString(){
        return "Customer endpoints.";
    }

    @Produce
    private ProducerTemplate template;
    
	@GetMapping("/customers/")
	public List<Customer> getCustomersCamel() {
		return (List<Customer>) customerRepository.findAll();
	}

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomerCamel(final @PathVariable String customerId){
    	String responsefromcamel =  (String) template.sendBody("direct:customer", ExchangePattern.InOut,customerId);
        Optional<Customer> theCustomer = customerRepository.findById(Integer.parseInt(responsefromcamel));
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setId(theCustomer.get().getId());
		customerResponse.setFirstName(theCustomer.get().getFirstName());
		customerResponse.setLastName(theCustomer.get().getLastName());
		customerResponse.setEmail(theCustomer.get().getEmail());
        return customerResponse;

    }
	// add mapping for POST /customer  - add new customer
	//TO TEST: Use POSTMAN , choose POST , paste the/customers url , click body tab and raw box,
	//then select from dropdown JSON(application/json)
	
	//the add as following before send
/*	
	{
	    "firstName": "yyy",
	    "lastName": "zzzz",
	    "email": "zzzzz@test.com"
	}
	*/
    @PostMapping(value="/customer",headers = "Accept=application/json", produces = "application/json")
    public CustomerResponse addCustomerCamel(@Valid @RequestBody Customer customerRequest) {
        System.out.println(customerRequest);
        Customer responsefromcamel = (Customer) template.sendBody("direct:customer", ExchangePattern.InOut, customerRequest);
        customerRepository.save(responsefromcamel);
        CustomerResponse customerResponse = getCustomerCamel(Integer.toString(responsefromcamel.getId()));
        return customerResponse;
    }
    
	/*
	// add mapping for PUT /customers - update existing customer
	//TO TEST: Use POSTMAN , choose PUT , paste the/customers url , click body tab and raw box,
	//then select from dropdown JSON(application/json)
	
	//LET UPDATE ID NO 4
	//the add as following before send
	
	{
	    "id": 4,
	    "firstName": "lololl",
	    "lastName": "popopo",
	    "email": "lopo@test.com"
	}
	*/
    
    @PutMapping(value="/customer",headers = "Accept=application/json", produces = "application/json")
    public CustomerResponse updateCustomerCamel(@Valid @RequestBody Customer customerRequest) {
        System.out.println(customerRequest);
        Customer responsefromcamel = (Customer) template.sendBody("direct:customer", ExchangePattern.InOut, customerRequest);
        customerRepository.save(responsefromcamel);
        CustomerResponse customerResponse = getCustomerCamel(Integer.toString(responsefromcamel.getId()));
        return customerResponse;
    }
    
	@DeleteMapping("/{customerId}")
	public String deleteCustomerByIdCamel(final @PathVariable String customerId) {
		
		String responsefromcamel =  (String) template.sendBody("direct:customer", ExchangePattern.InOut,customerId);	
		customerRepository.deleteById(Integer.parseInt(responsefromcamel));
		return "Deleted customer id - " + customerId;
	}
    
    
}

