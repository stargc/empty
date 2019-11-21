package com.example.empty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:config/application.yml", "classpath:config/system-dev.yml"},
		ignoreResourceNotFound = true)
public class EmptyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmptyApplication.class, args);
	}

}
