package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.books.entity.Books;
import com.books.service.BooksService;

@RestController
public class BookController {
	
	@Autowired
	BooksService bookService;
	
	@RequestMapping(value="/showBooks",method=RequestMethod.GET)
	public ModelAndView showBookForm(){
		
		return new ModelAndView("books","books",new Books());
	}
	@PostMapping(value="/saveBooks")
	public ModelAndView saveBooks(@ModelAttribute("books") Books books){
		
		System.out.println("inside saveBooks methods");
		
		bookService.saveBooks(books);
		
		
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/first")
	public ModelAndView booksShow() {
		return new ModelAndView("booksdetails");
	}
	
	

}
