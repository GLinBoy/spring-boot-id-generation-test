package com.glinboy.sample.nanoid.service.impl;

import com.glinboy.sample.nanoid.entity.Customer;
import com.glinboy.sample.nanoid.repository.CustomerRepository;
import com.glinboy.sample.nanoid.service.CustomerService;
import com.glinboy.sample.nanoid.service.IdGenerationService;
import com.glinboy.sample.nanoid.service.dto.CustomerDTO;
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
