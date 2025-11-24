package com.glinboy.sample.hibernateuuid.repository;

import com.glinboy.sample.hibernateuuid.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
