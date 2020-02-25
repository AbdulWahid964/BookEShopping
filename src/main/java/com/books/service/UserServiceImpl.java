package com.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.UsersDao;
import com.books.entity.Users;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public void saveUser(Users users) {
		usersDao.save(users);
		
	}

}
