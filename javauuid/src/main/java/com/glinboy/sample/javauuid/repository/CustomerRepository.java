package com.glinboy.sample.javauuid.repository;

import com.glinboy.sample.javauuid.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
