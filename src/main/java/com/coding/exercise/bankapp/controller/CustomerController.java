package com.coding.exercise.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.exercise.bankapp.domain.CustomerDetails;
import com.coding.exercise.bankapp.service.BankingServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("customers")
@Api(tags = { "Customer REST endpoints" })
public class CustomerController {

	@Autowired
	private BankingServiceImpl bankingService;

	@GetMapping(path = "/all")
	@ApiOperation(value = "Find all customers", notes = "Gets details of all the customers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public List<CustomerDetails> getAllCustomers() {

		return bankingService.findAll();
	}

	@PostMapping(path = "/add")
	@ApiOperation(value = "Add a Customer", notes = "Add customer and create an account")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> addCustomer(@RequestBody CustomerDetails customer) {

		return bankingService.addCustomer(customer);
	}

	@GetMapping(path = "/{customerNumber}")
	@ApiOperation(value = "Get customer details", notes = "Get Customer details by customer number.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = CustomerDetails.class, responseContainer = "Object"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public CustomerDetails getCustomer(@PathVariable Long customerNumber) {

		return bankingService.findByCustomerNumber(customerNumber);
	}

	@PutMapping(path = "/{customerNumber}")
	@ApiOperation(value = "Update customer", notes = "Update customer and any other account information associated with him.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerDetails customerDetails,
			@PathVariable Long customerNumber) {

		return bankingService.updateCustomer(customerDetails, customerNumber);
	}

	@DeleteMapping(path = "/{customerNumber}")
	@ApiOperation(value = "Delete customer and related accounts", notes = "Delete customer and all accounts associated with him.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerNumber) {

		return bankingService.deleteCustomer(customerNumber);
	}

}
