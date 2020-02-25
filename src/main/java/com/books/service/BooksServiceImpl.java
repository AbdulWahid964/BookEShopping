package com.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BooksDAO;
import com.books.entity.Books;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksDAO booksDao;
	
	
	@Override
	public void saveBooks(Books books) {
		// TODO Auto-generated method stub
		
		booksDao.save(books);
		
	}
	
	

	
}
