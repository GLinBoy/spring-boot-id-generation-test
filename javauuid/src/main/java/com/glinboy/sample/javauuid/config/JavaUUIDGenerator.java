package com.glinboy.sample.javauuid.config;

import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

/**
 * Custom UUID generator annotation for Hibernate entities.
 * This generator creates UUID v4 (random) identifiers.
 */
@IdGeneratorType(UUIDGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface JavaUUIDGenerator {
}

@Log4j2
class UUIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        val id = UUID.randomUUID();
        log.info("Generated UUID: {}", id);
        return id;
    }
}

