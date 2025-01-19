package com.glinboy.sample.longid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.sample.longid.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
