package com.glinboy.sample.hibernateuuidv7.repository;

import com.glinboy.sample.hibernateuuidv7.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
