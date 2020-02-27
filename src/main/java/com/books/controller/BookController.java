package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView saveBooks(@Validated @ModelAttribute("books") Books books,BindingResult result) {
		
		if(result.hasErrors()){
			return new ModelAndView("books");
		}
		bookService.saveBooks(books);
		return new ModelAndView("redirect:showBooks");
	}

	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)
	public ModelAndView showBookForm() {

		List<Books> list = bookService.findAll();
		return new ModelAndView("bookslist", "list", list);
	}

	@RequestMapping(value = "/remove/{bookID}", method = RequestMethod.GET)
	public ModelAndView deleteBook(@PathVariable("bookID") int bookID, Model model) {

		bookService.deleteBooks(bookID);	
		List<Books> list = bookService.findAll();
		return new ModelAndView("bookslist", "list", list);
	}


	@RequestMapping("/edit/{bookID}")
	public ModelAndView editBookForm(@PathVariable("bookID") int bookID ) {

		Books books = bookService.editBooks(bookID);
		if(books==null){
			throw new BookNotFoundException("Book Not Found Exception");
		}
		return new ModelAndView("books","books",books);
	}
	
	@ExceptionHandler
	public ResponseEntity<BooksResponseError> handleException(BookNotFoundException exception){
		BooksResponseError booksResponseError = new BooksResponseError();
		
		booksResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
		booksResponseError.setMessage(exception.getMessage());
		booksResponseError.setTimeStamp(System.currentTimeMillis());
	
		
		return new ResponseEntity<BooksResponseError>(booksResponseError,HttpStatus.BAD_REQUEST);
	}
	/*@ExceptionHandler
	public ModelAndView handleException(BookNotFoundException exception){
	//	BooksResponseError booksResponseError = new BooksResponseError();
		
		//booksResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
		//booksResponseError.setMessage(exception.getMessage());
		//booksResponseError.setTimeStamp(System.currentTimeMillis());
	
		return new ModelAndView("error","exception",exception.getMessage());
	//	return new ResponseEntity<BooksResponseError>(booksResponseError,HttpStatus.BAD_REQUEST);
	}*/
	
	
	
/*	@RequestMapping("/find")
	public ModelAndView searchBook(@RequestParam("bookname") String bookName)
	{
List<Books> list = bookService.getSearchBooks(bookName)​;
		return new ModelAndView("bookslist","list",list);
	}*/
	/*@RequestMapping(value = "/find")
	public ModelAndView searchBook(@RequestParam("bookname") String bookName) {​
	​
	List<Books> list = bookService.getSearchBooks(bookName);​
	return new ModelAndView("bookslist", "list", list);​
	}*/
	
	@RequestMapping("/find")
	public ModelAndView searchBook(@RequestParam("bookname") String bookName){
		
		List<Books> list= bookService.getSearchBooks(bookName);
		return new ModelAndView("bookslist","list",list);
	}
}
