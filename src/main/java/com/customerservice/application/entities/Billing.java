/**
 * 
 */
package com.customerservice.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.envers.Audited;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Ojo Gideon .O 26th January, 2022
 *
 */
@Audited
@Entity
public class Billing {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "MEDIUMINT NOT NULL AUTO_INCREMENT")
	@Schema(
			description = "generated customer unique identifier ID",
			example = "1",
			required = true
			)
    private int id;
    @Column(name = "accountNumber")
    @Schema(
			description = "billing account number",
			example = " 1029389487-01"
			)
    private String accountNumber;
    @Column(name = "tariff")
    @Schema(
			description = "billing tariff",
			example = "20",
			required = true
			)
    private Integer tariff;
    @Column(name = "tariffCurrency")
    @Schema(
			description = "Tariff's Currency type",
			example = "GBP/NGN/USD",
			required = true
			)
    @Email
    private String tariffCurrency;
    @Column(name = "customerID")
    @Schema(
			description = "customer's Unique Identifier",
			example = "1"
			)
    private String customerID;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the tariff
	 */
	public Integer getTariff() {
		return tariff;
	}
	/**
	 * @param tariff the tariff to set
	 */
	public void setTariff(Integer tariff) {
		this.tariff = tariff;
	}
	/**
	 * @return the tariffCurrency
	 */
	public String getTariffCurrency() {
		return tariffCurrency;
	}
	/**
	 * @param tariffCurrency the tariffCurrency to set
	 */
	public void setTariffCurrency(String tariffCurrency) {
		this.tariffCurrency = tariffCurrency;
	}
	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
    
    
}
