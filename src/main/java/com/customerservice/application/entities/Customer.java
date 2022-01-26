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
 * @author Giddytech
 *
 */
@Audited
@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "MEDIUMINT NOT NULL AUTO_INCREMENT")
	@Schema(
			description = "generated customer unique identifier ID",
			example = "1",
			required = true
			)
    private int id;
    @Column(name = "firstName")
    @Schema(
			description = "customer's first name",
			example = "Gideon",
			required = true
			)
    private String firstName;
    @Column(name = "lastName")
    @Schema(
			description = "customer's last name",
			example = "Ojo",
			required = true
			)
    private String lastName;
    @Column(name = "email")
    @Schema(
			description = "Customer's email address",
			example = "ojogideon@example.com",
			required = true
			)
    @Email
    private String email;
    @Column(name = "address")
    @Schema(
			description = "customer's address details",
			example = "10, lagos road, lagos"
			)
    private String address;
    @Column(name = "dateCreated")
    @Schema(
			description = "Customer Date Creation"
			)
    private String dateCreated;
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
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
    
    
}
