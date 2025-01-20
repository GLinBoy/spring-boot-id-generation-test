package com.glinboy.sample.nanoid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;
}
