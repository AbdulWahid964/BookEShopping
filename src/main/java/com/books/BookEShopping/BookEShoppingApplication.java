package com.books.BookEShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.books.configuration")
public class BookEShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookEShoppingApplication.class, args);
	}

}
