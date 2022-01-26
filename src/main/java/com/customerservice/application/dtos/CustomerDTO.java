package com.customerservice.application.dtos;

import javax.validation.constraints.Email;

import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerDTO {
	  @Schema(description = "customer's first name", example = "Gideon", required = true)
	  private String firstName;
	  
	  @Schema(description = "customer's last name", example = "ojo", required = true)
	  private String lastName;
	  
	  @Schema(description = "customer's email", example = "ojogideon@example.com", required = true)
	  @Email
	  private String email;
	  
	  @Schema(description = "customer's address", required = true)
	  private String address;
	  
	  @Schema(description = "customer's tariff", required = true)
	  private int customerTariff;
	  
	  @Schema(description = "currency type", required = true)
	  private String currencyType;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the customerTariff
	 */
	public int getCustomerTariff() {
		return customerTariff;
	}

	/**
	 * @param customerTariff the customerTariff to set
	 */
	public void setCustomerTariff(int customerTariff) {
		this.customerTariff = customerTariff;
	}

	/**
	 * @return the currencyType
	 */
	public String getCurrencyType() {
		return currencyType;
	}

	/**
	 * @param currencyType the currencyType to set
	 */
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	  
	  
}
