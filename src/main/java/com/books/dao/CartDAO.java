package com.books.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.books.entity.Cart;

public interface CartDAO extends CrudRepository<Cart, Integer>  {

	List<Cart> findByUsers(int userId);

	Cart findByCartID(int cartID);

	
	
}
