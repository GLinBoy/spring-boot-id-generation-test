package com.glinboy.sample.javauuid.config;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom UUID generator annotation for Hibernate entities.
 * This generator creates UUID v4 (random) identifiers.
 */
@IdGeneratorType(UUIDGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface JavaUUIDGenerator {
}

