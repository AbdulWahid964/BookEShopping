package com.books.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.books.entity.Books;

public interface BooksDAO extends CrudRepository<Books, Integer> {
	public List<Books> findByBookName(String bookName);
}
