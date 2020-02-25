package com.books.dao;

import org.springframework.data.repository.CrudRepository;

import com.books.entity.Books;

public interface BooksDAO extends CrudRepository<Books, Integer>  {

	
	
}
