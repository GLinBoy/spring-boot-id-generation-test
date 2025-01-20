package com.glinboy.sample.hibernateuuid.web.rest;

import com.glinboy.sample.hibernateuuid.service.CustomerService;
import com.glinboy.sample.hibernateuuid.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customers")
public class CustomerResource {

    private final CustomerService customerService;

    @PostMapping
    ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }
}
