package com.books.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.books")
public class BookConfiguration {
	
	@Bean 
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");   //  this is depretected com.mysql.cj.jdbc.Driver
		dataSource.setUrl("jdbc:mysql://localhost:3306/books");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}


}
