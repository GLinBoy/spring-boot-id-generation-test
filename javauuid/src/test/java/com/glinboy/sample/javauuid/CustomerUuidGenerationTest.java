package com.glinboy.sample.javauuid;

import com.glinboy.sample.javauuid.entity.Customer;
import com.glinboy.sample.javauuid.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerUuidGenerationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCustomUuidGeneratorIsUsed() {
        // Given
        Customer customer = new Customer();
        customer.setFirstname("John");
        customer.setLastname("Doe");

        // When
        Customer saved = customerRepository.save(customer);

        // Then
        assertThat(saved.getId()).isNotNull();
        System.out.println("Generated UUID: " + saved.getId());
    }
}

