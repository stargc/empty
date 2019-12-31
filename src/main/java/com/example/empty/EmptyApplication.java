package com.example.empty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:config/application.yml"},
		ignoreResourceNotFound = true)
@MapperScan("com.example.empty.infrastructure.persistence.mapper")
public class EmptyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmptyApplication.class, args);
	}

}
