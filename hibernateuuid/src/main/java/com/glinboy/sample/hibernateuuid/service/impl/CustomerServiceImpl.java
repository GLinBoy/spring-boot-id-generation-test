package com.glinboy.sample.hibernateuuid.service.impl;

import com.glinboy.sample.hibernateuuid.entity.Customer;
import com.glinboy.sample.hibernateuuid.repository.CustomerRepository;
import com.glinboy.sample.hibernateuuid.service.CustomerService;
import com.glinboy.sample.hibernateuuid.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = mapper.map(customerDTO, Customer.class);
        customer = customerRepository.save(customer);
        return mapper.map(customer, CustomerDTO.class);
    }

}
