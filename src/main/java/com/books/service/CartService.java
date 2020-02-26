package com.books.service;

import java.util.List;

import com.books.entity.Cart;

public interface CartService {

	public void save(Cart cart);

	public List<Cart> getCartDetails(int userId);

	public void deleteCart(int cartID);

	public Cart findBycartID(int cartID);
	
}
