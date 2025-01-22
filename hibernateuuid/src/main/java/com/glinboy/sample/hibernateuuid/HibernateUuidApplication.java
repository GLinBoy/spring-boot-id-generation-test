package com.glinboy.sample.hibernateuuid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HibernateUuidApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateUuidApplication.class, args);
	}

}
