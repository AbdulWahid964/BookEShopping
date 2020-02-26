package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.CartDAO;
import com.books.entity.Cart;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDAO cartDAO;

	@Override
	public void save(Cart cart) {
		cartDAO.save(cart);
		
	}

	@Override
	public List<Cart> getCartDetails(int userId) {
		List<Cart> cartList=cartDAO.findByUsers(userId);
		return cartList;
	}

	@Override
	public void deleteCart(int cartID) {
		cartDAO.delete(cartID);
		
	}

	@Override
	public Cart findBycartID(int cartID) {
		return cartDAO.findByCartID(cartID);
		
	}
	

}
