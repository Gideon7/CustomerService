/**
 * 
 */
package com.customerservice.application.services;

import com.customerservice.application.dtos.CustomerDTO;
import com.customerservice.application.dtos.ResponseDTO;

/**
 * @author Ojo Gideon .O 26th January, 2022 customer service api declaration (CRUD)
 *
 */
public interface CustomerService {
	ResponseDTO createCustomer(CustomerDTO customerDTO);
	ResponseDTO readCustomerRecord(int customerID);
	ResponseDTO fetchCustomers();
}
