package com.glinboy.sample.javauuid.service.impl;

import com.glinboy.sample.javauuid.service.IdGenerationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerationServiceImpl implements IdGenerationService {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
