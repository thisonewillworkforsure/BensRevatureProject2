package com.project2.springbootwebjdbcdatalombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.project2.springbootwebjdbcdatalombok.entity")
public class SpringBootWebJdbcDataLombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebJdbcDataLombokApplication.class, args);
	}

}
