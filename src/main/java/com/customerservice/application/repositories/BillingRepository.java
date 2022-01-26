package com.customerservice.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.application.entities.Billing;


@Repository("customerRepository")
public interface BillingRepository extends JpaRepository<Billing, Integer>{

	Billing findByCustomerID(String customerID);

}
