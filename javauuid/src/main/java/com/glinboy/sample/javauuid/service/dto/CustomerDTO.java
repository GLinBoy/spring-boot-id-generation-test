package com.glinboy.sample.javauuid.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private UUID id;
    private String firstname;
    private String lastname;
}
