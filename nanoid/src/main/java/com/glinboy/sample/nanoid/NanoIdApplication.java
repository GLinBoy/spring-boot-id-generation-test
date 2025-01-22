package com.glinboy.sample.nanoid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NanoIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(NanoIdApplication.class, args);
	}

}
