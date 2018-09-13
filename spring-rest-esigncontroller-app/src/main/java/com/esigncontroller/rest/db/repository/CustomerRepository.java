package com.esigncontroller.rest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esigncontroller.rest.db.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}