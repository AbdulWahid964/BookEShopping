package com.books.service;

import java.util.List;

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
		
		if(books.getBookID()>0){
			Books bookObj=booksDao.findOne(books.getBookID());
			if(bookObj.getBookID()>0){
				bookObj.setBookName(books.getBookName());
				bookObj.setAuthorName(books.getAuthorName());
				bookObj.setPrice(books.getPrice());
				bookObj.setQuantity(books.getQuantity());
				bookObj.setDescription(books.getDescription());
				booksDao.save(bookObj);
			}
		}
		
		booksDao.save(books);

	}

	@Override
	public List<Books> findAll() {
		return (List<Books>) booksDao.findAll();
	}

	@Override
	public void deleteBooks(int bookID) {
		booksDao.delete(bookID);
	}

	@Override
	public Books editBooks(int bookID) {
		return booksDao.findOne(bookID);
	}

	@Override
	public List<Books> getSearchBooks(String bookName) {
		return booksDao.findByBookName(bookName);
	}
	
}
