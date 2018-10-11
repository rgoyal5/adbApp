package com.verizon.bsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.verizon"})
public class BookstoreBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBootAppApplication.class, args);
	}
}
