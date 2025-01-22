package com.glinboy.sample.longid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LongIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(LongIdApplication.class, args);
	}

}
