package com.books.service;

import com.books.entity.Users;

public interface UserService {

	public void saveUser(Users users);

	public Users getUserName(String name);
	
}
