package com.customerservice.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.application.entities.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmail(String email);

}
