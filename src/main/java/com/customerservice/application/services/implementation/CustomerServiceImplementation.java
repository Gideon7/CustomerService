/**
 * 
 */
package com.customerservice.application.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerservice.application.dtos.CustomerDTO;
import com.customerservice.application.dtos.CustomerData;
import com.customerservice.application.dtos.ResponseDTO;
import com.customerservice.application.entities.Billing;
import com.customerservice.application.entities.Customer;
import com.customerservice.application.repositories.BillingRepository;
import com.customerservice.application.repositories.CustomerRepository;
import com.customerservice.application.services.CustomerService;
import com.customerservice.application.utils.DateConverter;
import com.customerservice.application.utils.NumberGenerator;

/**
 * @author Ojo Gideon .O 26th January, 2022
 *
 */
@Service("customerService")
public class CustomerServiceImplementation implements CustomerService {
	
	private static Logger logger= LoggerFactory.getLogger(CustomerServiceImplementation.class);
	
	private final CustomerRepository customerRepository;
	private final BillingRepository billingRepository;
	
	@Autowired
	DateConverter dateConverter;
	@Autowired
	NumberGenerator numberGenerator;
	
	public CustomerServiceImplementation(CustomerRepository customerRepository, BillingRepository billingRepository) {
		this.customerRepository = customerRepository;
		this.billingRepository = billingRepository;
	}
	
	
	@Override
	public ResponseDTO createCustomer(CustomerDTO customerDTO) {
		logger.info("Creating Customer And Adding Billing Details");
		ResponseDTO response = new ResponseDTO();
		CustomerData customerData = new CustomerData();
		try {
			
			if (customerDTO.getFirstName() == null || customerDTO.getFirstName().isEmpty() || customerDTO.getLastName() == null || customerDTO.getLastName().isEmpty()
					|| customerDTO.getEmail() == null || customerDTO.getEmail().isEmpty() || customerDTO.getCurrencyType() == null || customerDTO.getCurrencyType().isEmpty()) {
				response.setStatus("EMPTY_TEXTFIELDS");
				response.setMessage("Fill Up Empty Textfields!");
				return response;
			}
			Customer customerExist = customerRepository.findByEmail(customerDTO.getEmail());
			if (customerExist != null) {
				response.setStatus("ALREADY_EXISTS");
				response.setMessage("Customer With Email "+customerDTO.getEmail()+" Already Exist");
				return response;
			}
			
			Customer newCustomer = new Customer();
			newCustomer.setAddress(customerDTO.getAddress());
			newCustomer.setEmail(customerDTO.getEmail());
			newCustomer.setFirstName(customerDTO.getFirstName());
			newCustomer.setLastName(customerDTO.getLastName());
			newCustomer.setDateCreated(dateConverter.getCurrentDate());
			customerRepository.save(newCustomer);
			Billing newBilling = new Billing();
			newBilling.setAccountNumber(numberGenerator.generateAccountNumber().concat("-01"));
			newBilling.setCustomerID(""+newCustomer.getId());
			newBilling.setTariff(customerDTO.getCustomerTariff());
			newBilling.setTariffCurrency(customerDTO.getCurrencyType());
			billingRepository.save(newBilling);
			customerData.setCustomer(newCustomer);
			customerData.setBilling(newBilling);
			
			response.setStatus("SUCCESS");
			response.setMessage("Customer Added Successfully");
			response.setData(customerData);
			return response;
		}catch(Exception e) {
			logger.error("Unable To Implement Customer Creation");
			response.setStatus("ERROR");
			response.setMessage(""+e);
			return response;
		}
	}

	@Override
	public ResponseDTO readCustomerRecord(int customerID) {
		logger.info("Fetching A Particular Customer Record");
		
		CustomerData customerData = new CustomerData();
		ResponseDTO response = new ResponseDTO();
		Optional<Customer> customer = customerRepository.findById(customerID);
		if (customer.isPresent()) {
			Billing billing = billingRepository.findByCustomerID(""+customer.get().getId());
			if (billing != null) {
				customerData.setBilling(billing);
			}
			customerData.setCustomer(customer.get());
			response.setStatus("SUCCESS");
			response.setMessage("Customer Record Fetched Successfully");
			response.setData(customerData);
			return response;
		}
		response.setStatus("NOT_FOUND");
		response.setMessage("Invalid Customer ID supplied");
		return response;
	}

	@Override
	public ResponseDTO fetchCustomers() {
		logger.info("Fetching All Customer Records With Their Billings");
		
		ResponseDTO response = new ResponseDTO();
		List<CustomerData> customerDatas = new ArrayList<>();
		List<Customer> customers= customerRepository.findAll();
		if (customers != null && customers.size() > 0) {
			for (Customer customer : customers) {
				CustomerData customerData = new CustomerData();
				Billing billing = billingRepository.findByCustomerID(""+customer.getId());
				customerData.setBilling(billing);
				customerData.setCustomer(customer);
				customerDatas.add(customerData);
			}
		}
		response.setStatus("SUCCESS");
		response.setMessage("Customers Fetched Successfully");
		response.setData(customerDatas);
		return response;
	}

}
