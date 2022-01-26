package com.customerservice.application.dtos;

import com.customerservice.application.entities.Billing;
import com.customerservice.application.entities.Customer;

public class CustomerData {
	private Customer customer;
	private Billing billing;
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the billing
	 */
	public Billing getBilling() {
		return billing;
	}
	/**
	 * @param billing the billing to set
	 */
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	
	
}
