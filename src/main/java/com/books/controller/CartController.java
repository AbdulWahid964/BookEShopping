package com.books.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.books.entity.Books;
import com.books.entity.Cart;
import com.books.entity.Users;
import com.books.service.BooksService;
import com.books.service.CartService;
import com.books.service.UserService;

@RestController
public class CartController {
	private static final Logger logger = LogManager.getLogger(CartController.class);
	@Autowired
	CartService cartService;
	@Autowired
	BooksService bookService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/viewcart/{bookID}")
	public ModelAndView searchBook(@PathVariable("bookID") int bookID){
		SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();       
        String name= authentication.getName();
        Users user = userService.getUserName(name);
        if(bookID > 0) {
        logger.info("Adding book to cart using book id "+bookID);
		Books book = bookService.editBooks(bookID);
		Cart cart = new Cart();
		cart.setBookName(book.getBookName());
		cart.setDescription(book.getDescription());
		cart.setPrice(book.getPrice());
		cart.setUsers(user.getUserId());
		cart.setBookId(bookID);
		
		cartService.save(cart);
		}
	   List<Cart> list=	cartService.getCartDetails(user.getUserId());
	   logger.info("Viewing Cart details for "+name);
		return new ModelAndView("viewCart", "cartDetails", list);
	}
	
	@RequestMapping("deletecart/{cartID}")
	public ModelAndView deleteCartItem(@PathVariable("cartID") int cartID){
		
		System.out.println("remove");
		//Cart cart = cartService.findBycartID(cartID);
		//if(cart!=null) {
		cartService.deleteCart(cartID);
		//}

		SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();       
        String name= authentication.getName();
        Users user = userService.getUserName(name);
		List<Cart> list=	cartService.getCartDetails(user.getUserId());
		return new ModelAndView("viewCart", "cartDetails", list);
	}
	
}
