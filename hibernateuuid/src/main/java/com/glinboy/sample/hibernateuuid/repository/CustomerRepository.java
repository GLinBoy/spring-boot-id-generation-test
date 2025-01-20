package com.glinboy.sample.hibernateuuid.repository;

import com.glinboy.sample.hibernateuuid.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
