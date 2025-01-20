package com.glinboy.sample.javauuid.service.impl;

import com.glinboy.sample.javauuid.entity.Customer;
import com.glinboy.sample.javauuid.repository.CustomerRepository;
import com.glinboy.sample.javauuid.service.CustomerService;
import com.glinboy.sample.javauuid.service.IdGenerationService;
import com.glinboy.sample.javauuid.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final IdGenerationService idGenerationService;
    private final ModelMapper mapper;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = mapper.map(customerDTO, Customer.class);
        customer.setId(idGenerationService.generateId());
        customer = customerRepository.save(customer);
        return mapper.map(customer, CustomerDTO.class);
    }

}
