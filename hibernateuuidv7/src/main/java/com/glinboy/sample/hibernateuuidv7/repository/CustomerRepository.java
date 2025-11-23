package com.glinboy.sample.hibernateuuidv7.repository;

import com.glinboy.sample.hibernateuuidv7.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
