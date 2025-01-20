package com.glinboy.sample.nanoid.service.impl;

import com.glinboy.sample.nanoid.service.IdGenerationService;
import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerationServiceImpl implements IdGenerationService {
    @Override
    public String generateId() {
        return NanoIdUtils.randomNanoId();
    }
}
