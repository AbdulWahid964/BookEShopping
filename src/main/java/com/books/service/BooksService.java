package com.books.service;

import java.util.List;
import com.books.entity.Books;

public interface BooksService {

	public void saveBooks(Books books);

	public List<Books> findAll();

	public void deleteBooks(int bookID);
	
	public Books editBooks(int bookID);
}
