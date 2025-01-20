package com.glinboy.sample.nanoid.repository;

import com.glinboy.sample.nanoid.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
