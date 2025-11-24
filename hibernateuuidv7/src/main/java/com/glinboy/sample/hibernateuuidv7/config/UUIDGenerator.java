package com.glinboy.sample.hibernateuuidv7.config;

import com.glinboy.sample.hibernateuuidv7.utils.UUIDUtils;
import lombok.extern.log4j.Log4j2;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@Log4j2
public class UUIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return UUIDUtils.randomV7();
    }
}
