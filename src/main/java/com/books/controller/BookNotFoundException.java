package com.books.controller;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
