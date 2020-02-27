package com.books.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import com.books.dao.BooksDAO;
import com.books.entity.Books;
import com.books.service.BooksServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private BookController bookController;
	private Books books;
	private BooksServiceImpl booksService;
	private Field field;
	private Field field1;
	
	@Mock
	private BindingResult result;
	@Mock
	private BooksDAO booksDao;

	@Before
	public void setUp() throws Exception {
		bookController = new BookController();
		books = new Books();
		booksService = new BooksServiceImpl();
		
		field = BookController.class.getDeclaredField("bookService");
		field.setAccessible(true);
		field.set(bookController, booksService);

		field1 = BooksServiceImpl.class.getDeclaredField("booksDao");
		field1.setAccessible(true);
		field1.set(booksService, booksDao);
	}

	@Test
	public void testAddBookForm() {
		assertEquals("books", bookController.addBookForm(books).getViewName());
	}

	@Test
	public void testSaveBooks() {
		books.setBookName("java");
		books.setBookID(1);
		books.setAuthorName("authorName");
		books.setDescription("description");
		books.setPrice(120);
		books.setQuantity(2);
		Mockito.when(booksDao.findOne(Matchers.anyInt())).thenReturn(books);
		Mockito.when(booksDao.save(books)).thenReturn(books);
		assertEquals("redirect:showBooks", bookController.saveBooks(books, result).getViewName());
	}

/*	@Test
	public void testShowBookForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditBookForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleException() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBook() {
		fail("Not yet implemented");
	}
*/
	@After
	public void tearDown() throws Exception {
		bookController = null;
		books = null;
		booksService = null;
		result = null;
		booksDao = null;
		field = null;
		field1 = null;
	}
}
