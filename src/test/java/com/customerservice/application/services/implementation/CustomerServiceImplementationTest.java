/**
 * 
 */
package com.customerservice.application.services.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import com.customerservice.application.dtos.CustomerDTO;
import com.customerservice.application.entities.Billing;
import com.customerservice.application.entities.Customer;
import com.customerservice.application.repositories.BillingRepository;
import com.customerservice.application.repositories.CustomerRepository;

/**
 * @author Giddytech
 *
 */
class CustomerServiceImplementationTest {
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private BillingRepository billingRepository;
	
	@Mock
	CustomerServiceImplementation underTest;
	
	@Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;
	
	@Captor
    private ArgumentCaptor<Billing> billingArgumentCaptor;

	@Test
	void itShouldAddNewCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Timi");
		customerDTO.setLastName("Ojo");
		customerDTO.setEmail("ojotimi@example.com");
		customerDTO.setCurrencyType("NGN");
		customerDTO.setAddress("lagos");
		
		Customer testCustomer = new Customer();
		testCustomer.setAddress(customerDTO.getAddress());
		testCustomer.setEmail(customerDTO.getEmail());
		testCustomer.setFirstName(customerDTO.getFirstName());
		testCustomer.setLastName(customerDTO.getLastName());
		testCustomer.setDateCreated("26/01/22 14:06:00");
		
		Billing testBilling = new Billing();
		testBilling.setAccountNumber("1234567892-01");
		testBilling.setCustomerID(""+testCustomer.getId());
		testBilling.setTariff(20);
		testBilling.setTariffCurrency(customerDTO.getCurrencyType());
		
		 given(customerRepository.findByEmail(testCustomer.getEmail()))
         .willReturn(null);
		 
		 then(customerRepository).should().save(customerArgumentCaptor.capture());
		 then(billingRepository).should().save(billingArgumentCaptor.capture());
		 
		 Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();
		 Billing billingArgumentCaptorValue = billingArgumentCaptor.getValue();
		 assertThat(customerArgumentCaptorValue).isEqualTo(testCustomer);
		 assertThat(billingArgumentCaptorValue).isEqualTo(testBilling);
	}
	
	@Test
	void itShouldReturnResponseOfEmptyTextfields() {
		
	}

}
