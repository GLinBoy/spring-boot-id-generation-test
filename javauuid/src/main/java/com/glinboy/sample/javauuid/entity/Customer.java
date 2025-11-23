package com.glinboy.sample.javauuid.entity;

import com.glinboy.sample.javauuid.config.JavaUUIDGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @JavaUUIDGenerator
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;
}
