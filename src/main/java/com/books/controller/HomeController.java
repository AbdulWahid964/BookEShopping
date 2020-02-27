package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.books.entity.Books;
import com.books.service.BooksService;

@RestController
public class HomeController {

	@Autowired
	BooksService bookService;
	
	@RequestMapping("/home")
	public ModelAndView showHome(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String role= auth.getAuthorities().toString();
	    model.addAttribute("role",role);
	    List<Books> list = bookService.findAll();
		return new ModelAndView("/home", "list", list);
	    
	}

}
