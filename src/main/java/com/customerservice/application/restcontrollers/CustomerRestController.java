package com.customerservice.application.restcontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.application.dtos.CustomerDTO;
import com.customerservice.application.dtos.ResponseDTO;
import com.customerservice.application.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController("commentRestController")
@Tag(name="Comment Endpoints", description="This services shows customer creation processes and retrival")
@RequestMapping("/customer")
public class CustomerRestController {
	private static Logger logger= LoggerFactory.getLogger(CustomerRestController.class);
	
	private CustomerService customerService;
	
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping(value="/")
	@Operation(summary = "Create Customer", description="This route creates a new customer")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Customer Created Successfully"),
	  @ApiResponse(responseCode = "404", description = "Customer Already Exist"),
	  @ApiResponse(responseCode = "501", description = "An error occured"),
	  @ApiResponse(responseCode = "400", description = "Bad request")})
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
		logger.info("API Call To Create Customer");
		
		try {
				
			ResponseDTO retResponse = customerService.createCustomer(customerDTO);
			if(retResponse.getStatus().equalsIgnoreCase("SUCCESS")) {
				return new ResponseEntity<>(retResponse, HttpStatus.OK);
			}else if(retResponse.getStatus().equalsIgnoreCase("EMPTY_TEXTFIELDS")) { 
				return new  ResponseEntity<>(retResponse, HttpStatus.PRECONDITION_REQUIRED);
			}else if(retResponse.getStatus().equalsIgnoreCase("ALREADY_EXISTS")){
				return new ResponseEntity<>(retResponse, HttpStatus.EXPECTATION_FAILED);
			}
			else {
				return new ResponseEntity<>(retResponse, HttpStatus.NOT_IMPLEMENTED);
			}
		}catch(Exception e) {
           logger.error("Exception occurred " + e);
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/{customerID}")
	@Operation(summary = "Fetch Customer With ID", description="This route fetches a particular customer")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Customer Fetched Successfully"),
	  @ApiResponse(responseCode = "404", description = "Customer Not Found"),
	  @ApiResponse(responseCode = "501", description = "An error occured"),
	  @ApiResponse(responseCode = "400", description = "Bad request")})
	public ResponseEntity<?> fetchCustomer(@PathVariable int customerID) {
		logger.info("API Call To Get A Particular Customer");
		
		try {
			ResponseDTO retResponse = customerService.readCustomerRecord(customerID);
			if (retResponse.getStatus().equalsIgnoreCase("success")) {
				return new ResponseEntity<>(retResponse, HttpStatus.OK);
			}
			else if (retResponse.getStatus().equalsIgnoreCase("NOT_FOUND")) {
				return new ResponseEntity<>(retResponse, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}catch(Exception e) {
           logger.error("Exception occurred " + e);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/all")
	@Operation(summary = "Fetch All Customers", description="This route fetches all customers in database")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Customers Fetched Successfully"),
	  @ApiResponse(responseCode = "404", description = "Customers Not Found"),
	  @ApiResponse(responseCode = "501", description = "An error occured"),
	  @ApiResponse(responseCode = "400", description = "Bad request")})
	public ResponseEntity<?> fetchCustomers() {
		logger.info("API Call To Fetch All Customers");
		
		try {
			ResponseDTO retResponse = customerService.fetchCustomers();
			if (retResponse.getStatus().equalsIgnoreCase("success")) {
				return new ResponseEntity<>(retResponse, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}catch(Exception e) {
           logger.error("Exception occurred " + e);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
