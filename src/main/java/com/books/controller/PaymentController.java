package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.books.entity.Payment;
import com.books.service.PaymentService;
@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/payment")
	public ModelAndView paymentMethod(){

		System.out.println("payment");
		return new ModelAndView("payment");
		
	}
	@RequestMapping("/cart/{id}")
	public ModelAndView cartMethod(@PathVariable("id")int id){

		
		return new ModelAndView("payment");
		
	}
/*	@RequestMapping("/showUserRegistration")
	public ModelAndView showUserRegisterForm(){
		return new ModelAndView("payment","payments",new );
	}*/
	@PostMapping("paymentForm")
	public String saveUserRegistrationForm(@Validated @RequestParam("userId") int userId,
			@RequestParam("bookId") int bookId,
			@RequestParam("cardName") String cardName,
			@RequestParam("mm") int mm,
			@RequestParam("yy") double yy,
			@RequestParam("cardNo") int cardNo){
		System.out.println("========="+userId);
		Payment payments = new Payment();
		payments.setBookId(bookId);
		payments.setCardName(cardName);
		payments.setUserId(userId);
		payments.setCardNo(cardNo);
		paymentService.savePayments(payments);
		return "success";

	}
}
