package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/addBooks", method = RequestMethod.GET)
	public ModelAndView addBookForm(@ModelAttribute("books") Books books) {

		return new ModelAndView("books");
	}

	@PostMapping(value = "/saveBooks")
	public ModelAndView saveBooks(@ModelAttribute("books") Books books) {
		
		bookService.saveBooks(books);
		return new ModelAndView("redirect:showBooks");
	}

	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)
	public ModelAndView showBookForm() {

		List list = bookService.findAll();
		return new ModelAndView("bookslist", "list", list);
	}

	@RequestMapping(value = "/remove/{bookID}", method = RequestMethod.GET)
	public ModelAndView deleteBook(@PathVariable("bookID") int bookID, Model model) {

		bookService.deleteBooks(bookID);	
		List list = bookService.findAll();
		return new ModelAndView("bookslist", "list", list);
	}


	@RequestMapping("/edit/{bookID}")
	public ModelAndView editBookForm(@PathVariable("bookID") int bookID ) {

		Books books = bookService.editBooks(bookID);
		return new ModelAndView("books","books",books);
	}

}
